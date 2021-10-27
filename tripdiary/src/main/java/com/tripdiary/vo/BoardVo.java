package com.tripdiary.vo;

import java.sql.Timestamp;
import java.sql.Date;

public class BoardVo {
	private int boardNum;
	private int memberNum;
	private String place;
	private String content;
	private Timestamp regdate;
	private Date tripdate;
	private int tdLiktCnt;

	public BoardVo() {

	}

	public BoardVo(int boardNum, int memberNum, String place, String content, Timestamp regdate, Date tripdate,
			int tdLiktCnt) {
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.place = place;
		this.content = content;
		this.regdate = regdate;
		this.tripdate = tripdate;
		this.tdLiktCnt = tdLiktCnt;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Date getTripdate() {
		return tripdate;
	}

	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}

	public int getTdLiktCnt() {
		return tdLiktCnt;
	}

	public void setTdLiktCnt(int tdLiktCnt) {
		this.tdLiktCnt = tdLiktCnt;
	}

}
