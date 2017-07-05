package com.hanbit.board.domain;

public class BoardBean {
	private int seq;
	private String writer, title, content, regdate;
	
	public void setSeq(int seq) {
		this.seq=seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setWriter(String writer) {
		this.writer=writer;
	}
	public String getWriter() {
		return writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getRegdate() {
		return regdate;
	}
	public String toString() {
		return "글번호: "+seq + " / "+ "작성자: "+writer+ " / "+"작성일자: "+regdate+ " / "+"제목: "+title+ " / " + "내용: "+content;
	}
}
