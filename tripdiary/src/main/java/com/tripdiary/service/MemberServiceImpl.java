package com.tripdiary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.dao.MemberDao;
import com.tripdiary.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	// DB와 연결 (의존주입)
	@Inject
	private MemberDao dao;

	// 회원가입
	@Override
	public void register(MemberVo vo) throws Exception {
		dao.register(vo);

	}

	// 로그인
	public MemberVo login(MemberVo vo) throws Exception {
		return dao.login(vo);
	}

}
