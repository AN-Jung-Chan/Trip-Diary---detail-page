package com.tripdiary.service;

import com.tripdiary.vo.MemberVo;

public interface MemberService {

	// 회원가입
	public void register(MemberVo vo) throws Exception;

	// 로그인
	public MemberVo login(MemberVo vo) throws Exception;

}
