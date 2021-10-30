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
	private int tdLiktCnt;
	private String boardOrgFileName;
	private String boardStoreFileName;
	private String boardFileType;
	private String profileOrgFileName;
	private String profileStoreFileName;
	private String profileFileType;

	public ReadVo() {
		// TODO Auto-generated constructor stub
	}

	public ReadVo(int boardNum, int memberNum, String nickname, String content, Timestamp regdate, Date tripdate,
			int tdLiktCnt, String boardOrgFileName, String boardStoreFileName, String boardFileType,
			String profileOrgFileName, String profileStoreFileName, String profileFileType) {
		super();
		this.boardNum = boardNum;
		this.memberNum = memberNum;
		this.nickname = nickname;
		this.content = content;
		this.regdate = regdate;
		this.tripdate = tripdate;
		this.tdLiktCnt = tdLiktCnt;
		this.boardOrgFileName = boardOrgFileName;
		this.boardStoreFileName = boardStoreFileName;
		this.boardFileType = boardFileType;
		this.profileOrgFileName = profileOrgFileName;
		this.profileStoreFileName = profileStoreFileName;
		this.profileFileType = profileFileType;
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

	public int getTdLiktCnt() {
		return tdLiktCnt;
	}

	public void setTdLiktCnt(int tdLiktCnt) {
		this.tdLiktCnt = tdLiktCnt;
	}

	public String getBoardOrgFileName() {
		return boardOrgFileName;
	}

	public void setBoardOrgFileName(String boardOrgFileName) {
		this.boardOrgFileName = boardOrgFileName;
	}

	public String getBoardStoreFileName() {
		return boardStoreFileName;
	}

	public void setBoardStoreFileName(String boardStoreFileName) {
		this.boardStoreFileName = boardStoreFileName;
	}

	public String getBoardFileType() {
		return boardFileType;
	}

	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}

	public String getProfileOrgFileName() {
		return profileOrgFileName;
	}

	public void setProfileOrgFileName(String profileOrgFileName) {
		this.profileOrgFileName = profileOrgFileName;
	}

	public String getProfileStoreFileName() {
		return profileStoreFileName;
	}

	public void setProfileStoreFileName(String profileStoreFileName) {
		this.profileStoreFileName = profileStoreFileName;
	}

	public String getProfileFileType() {
		return profileFileType;
	}

	public void setProfileFileType(String profileFileType) {
		this.profileFileType = profileFileType;
	}

	@Override
	public String toString() {
		return "ReadVo [boardNum=" + boardNum + ", memberNum=" + memberNum + ", nickname=" + nickname + ", content="
				+ content + ", regdate=" + regdate + ", tripdate=" + tripdate + ", tdLiktCnt=" + tdLiktCnt
				+ ", boardOrgFileName=" + boardOrgFileName + ", boardStoreFileName=" + boardStoreFileName
				+ ", boardFileType=" + boardFileType + ", profileOrgFileName=" + profileOrgFileName
				+ ", profileStoreFileName=" + profileStoreFileName + ", profileFileType=" + profileFileType + "]";
	}

}
