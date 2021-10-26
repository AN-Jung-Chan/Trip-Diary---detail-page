package com.tripdiary.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	// DB연결 (xml에서 만들어진 객체를 가져다 사용하고자함 = 의존 주입)
	@Inject
	private SqlSession sqlSession; // mapper위치까지 접근 가능 but mapper가 여러개일수있음 => mapper구분필요

	// 회원가입
	@Override
	public void register(MemberVo vo) throws Exception {
		sqlSession.insert("memberMapper.register", vo);
	}

	// 로그인
	@Override
	public MemberVo login(MemberVo vo) throws Exception {
		return sqlSession.selectOne("memberMapper.login", vo);
	}

	// 회원 정보 조회-사용자 ID 해당하는 정보 가져오기
	@Override
	public MemberVo readMember(String id) throws Exception {
		// 테스트(컨트롤러) 호출 -> 정보를 저장 -> DB로이동
		MemberVo vo = sqlSession.selectOne("memberMapper.readMember", id); // 괄호안의 물음표를 콤마뒤에 쓰는거임
		return vo;
	}

}
