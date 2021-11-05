package com.tripdiary.JCcontroller;

public class MemberCntCmd {
	private int boardNum; // 게시글 번호
	private int boardMemberNum; // 게시글 쓴 회원
	private int loginMemberNum; // 로그인 한 회원
	private String memberAct; // 픽이랑 라이크 둘중하나 받음
	private String updateType; // insert delete

	public MemberCntCmd() {
		// TODO Auto-generated constructor stub
	}

	public MemberCntCmd(int boardNum, int boardMemberNum, int loginMemberNum, String memberAct, String updateType) {
		super();
		this.boardNum = boardNum;
		this.boardMemberNum = boardMemberNum;
		this.loginMemberNum = loginMemberNum;
		this.memberAct = memberAct;
		this.updateType = updateType;
	}

	protected int getBoardNum() {
		return boardNum;
	}

	protected void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	protected int getBoardMemberNum() {
		return boardMemberNum;
	}

	protected void setBoardMemberNum(int boardMemberNum) {
		this.boardMemberNum = boardMemberNum;
	}

	protected int getLoginMemberNum() {
		return loginMemberNum;
	}

	protected void setLoginMemberNum(int loginMemberNum) {
		this.loginMemberNum = loginMemberNum;
	}

	protected String getMemberAct() {
		return memberAct;
	}

	protected void setMemberAct(String memberAct) {
		this.memberAct = memberAct;
	}

	protected String getUpdateType() {
		return updateType;
	}

	protected void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	@Override
	public String toString() {
		return "MemberCntCmd [boardNum=" + boardNum + ", boardMemberNum=" + boardMemberNum + ", loginMemberNum="
				+ loginMemberNum + ", memberAct=" + memberAct + ", updateType=" + updateType + "]";
	}

}
