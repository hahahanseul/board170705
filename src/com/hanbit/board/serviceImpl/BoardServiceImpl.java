package com.hanbit.board.serviceImpl;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService {
	int count;
	int seqCount;
	BoardBean board;
	BoardBean[] list;
	public BoardServiceImpl() {
		count=0;
		seqCount=0;
		board = new BoardBean();
		list = new BoardBean[count];
	}

	@Override
	public void writeBoard(BoardBean board) {
		seqCount++;
		board.setSeq(seqCount);
		if(count==list.length) {
			BoardBean[] temp = new BoardBean[count+1];
			System.arraycopy(list, 0, temp, 0, count);
			list = temp;
		}
		list[count++] = board;
		System.out.println(board.toString());
	}
	@Override
	public int countBoards() {
		return count;
	}
	@Override
	public BoardBean[] getBoards() {
		return list;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		for(int i=0;i<count;i++) {
			if(seq == list[i].getSeq()) {
				board = list[i];
				break;
			}
		}
		return board;
	}

	@Override
	public BoardBean[] findByWriter(String writer) {
		int x=0;
		for(int i=0;i<count;i++) {
			if(writer.equals(list[i].getWriter())) {
				x++;
			}
		}
		BoardBean[] writers = new BoardBean[x];
		int j=0;
		for(int i=0;i<count;i++) {
			if(writer.equals(list[i].getWriter())) {
				writers[j]=list[i];
				j++;
			}
			if(x==j) {
				break;
			}
		}
		return writers;
	}

	@Override
	public void updateContent(BoardBean param) {
		board=findBySeq(param.getSeq());
		board.setContent(param.getContent());
	}

	@Override
	public void deleteBoard(int param) {
		for(int i=0;i<count;i++) {
			if(param==list[i].getSeq()) {
				list[i]=list[count-1];
				list[count-1]=null;
				count--;
				break;
			}
		}
	}
}
