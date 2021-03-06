package com.tripdiary.JCvo;

import java.security.Timestamp;

public class MemberVo {
	private int memberNum;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String birthYear;
	private String birth;
	private Timestamp regdate;
	private String gender;
	private int admin;

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberVo [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", birthYear=" + birthYear + ", birth=" + birth + ", regdate=" + regdate
				+ ", gender=" + gender + ", admin=" + admin + "]";
	}

}
