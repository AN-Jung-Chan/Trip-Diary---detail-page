package com.tripdiary.JCcontroller;

public class ReadViewCmd {
	private int boardNum;
	private int memberNum;
	private int tdLikeCnt;

	public ReadViewCmd() {
		// TODO Auto-generated constructor stub
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getTdLikeCnt() {
		return tdLikeCnt;
	}

	public void setTdLikeCnt(int tdLikeCnt) {
		this.tdLikeCnt = tdLikeCnt;
	}

	@Override
	public String toString() {
		return "ReadViewCmd [boardNum=" + boardNum + ", memberNum=" + memberNum + ", tdLikeCnt=" + tdLikeCnt + "]";
	}

}
