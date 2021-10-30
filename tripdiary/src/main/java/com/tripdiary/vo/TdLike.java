package com.tripdiary.vo;

public class TdLike {
	private int tdlikeNum;
	private int memberNum;
	private int boardNum;

	public TdLike() {
	}

	public TdLike(int tdlikeNum, int memberNum, int boardNum) {
		super();
		this.tdlikeNum = tdlikeNum;
		this.memberNum = memberNum;
		this.boardNum = boardNum;
	}

	public int getTdlikeNum() {
		return tdlikeNum;
	}

	public void setTdlikeNum(int tdlikeNum) {
		this.tdlikeNum = tdlikeNum;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "TdLike [tdlikeNum=" + tdlikeNum + ", memberNum=" + memberNum + ", boardNum=" + boardNum + "]";
	}

}
