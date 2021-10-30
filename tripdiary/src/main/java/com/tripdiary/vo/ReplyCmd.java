package com.tripdiary.vo;

import java.sql.Timestamp;

public class ReplyCmd {
	private int replyNum;
	private int boardNum;
	private int memberNum;
	private String nickname;
	private String content;
	private Timestamp regdate;

	public ReplyCmd() {
		// TODO Auto-generated constructor stub
	}

	public ReplyCmd(int replyNum, int boardNum, int memberNum, String nickname, String content, Timestamp regdate) {
		super();
		this.replyNum = replyNum;
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
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

	@Override
	public String toString() {
		return "ReplyVo [replyNum=" + replyNum + ", boardNum=" + boardNum + ", memberNum=" + memberNum + ", nickname="
				+ nickname + ", content=" + content + ", regdate=" + regdate + "]";
	}

}