package com.hanbit.board.controller;

import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		BoardBean board = null;
		while(true) {
			switch(JOptionPane.showInputDialog("0.close 1.write 2.countBoards 3.getBoards 4.findBySeq 5.findByWriter 6.update 7.delete")) {
			case "0":
				return;
			case "1":
				board = new BoardBean();
				String[] arr=JOptionPane.showInputDialog("작성자/작성일자/제목/작성내용").split("/");
				board.setWriter(arr[0]);
				board.setRegdate(arr[1]);				
				board.setTitle(arr[2]);				
				board.setContent(arr[3]);
				service.writeBoard(board);
				JOptionPane.showMessageDialog(null, "글 작성완료!");
				break;
			case "2":
				JOptionPane.showMessageDialog(null,service.countBoards());
				break;
			case "3":
				BoardBean[] list = service.getBoards();
				String sList="";
				for(int i=0;i<service.countBoards();i++){
					sList+=list[i].toString()+"\n";
				}
				JOptionPane.showMessageDialog(null, "리스트\n"+sList);
				break;
			case "4":
				JOptionPane.showMessageDialog(null,service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("글번호를 입력하세요."))).toString());
				break;
			case "5":
				BoardBean[] writers=service.findByWriter(JOptionPane.showInputDialog("작성자를 입력하세요."));
				String result="";
				if(writers.length == 0) {
					result = "작성글이 없습니다.";
				}else {
					for(int i=0;i<writers.length;i++) {
						result += writers[i].toString()+"\n";
					}
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			case "6":
				board = new BoardBean();
				board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("글번호를 입력하세요")));
				board.setContent(JOptionPane.showInputDialog("수정내용을 입력하세요"));
				service.updateContent(board);
				JOptionPane.showMessageDialog(null, "수정완료");

				break;
			case "7":
				service.deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("삭제할 글번호를 입력하세요.")));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
			}
		}
	}
}
