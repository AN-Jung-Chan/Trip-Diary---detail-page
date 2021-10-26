package com.tripdiary.dao;

import com.tripdiary.vo.MemberVo;

public interface MemberDao {

	// C:회원가입
	public void register(MemberVo vo) throws Exception;

	// 로그인
	public MemberVo login(MemberVo vo) throws Exception;

	// R: 회원 정보 조회 - 사용자 ID 해당하는 정보 가져오기
	public MemberVo readMember(String id) throws Exception;

}
