package com.tripdiary.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.BoardVo;

@Repository
public class ReadDaoImpl implements ReadDao {

	@Inject
	private SqlSession sqlSession;

	// 게시물 상세 보기 - 맡은 주 기능
	@Override
	public BoardVo read(int boardNum) throws Exception {
		return sqlSession.selectOne("readMapper.read", boardNum);
	}

}
