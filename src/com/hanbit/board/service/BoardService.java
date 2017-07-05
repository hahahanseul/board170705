package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board);
	public BoardBean[] getBoards();
	public BoardBean findBySeq(int seq);
	public BoardBean[] findByWriter(String writer);
	public int countBoards();
	public void updateContent(BoardBean board);
	public void deleteBoard(int seq);
	
}
