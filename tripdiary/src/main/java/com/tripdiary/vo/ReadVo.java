package com.tripdiary.vo;

import java.sql.Timestamp;
import java.util.Date;

public class ReadVo {
	private int boardNum;
	private int memberNum;
	private String nickname;
	private String content;
	private Timestamp regdate;
	private Date tripdate;

	public ReadVo() {
	}

	public ReadVo(int boardNum, int memberNum, String nickname, String content, Timestamp regdate, Date tripdate) {
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.tripdate = tripdate;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	@Override
	public String toString() {
		return "ReadVo [boardNum=" + boardNum + ", memberNum=" + memberNum + ", nickname=" + nickname + ", content="
				+ content + ", regdate=" + regdate + ", tripdate=" + tripdate + "]";
	}

}
