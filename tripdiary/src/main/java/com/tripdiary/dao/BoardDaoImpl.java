package com.tripdiary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.BoardVo;
import com.tripdiary.vo.SearchCriteria;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession sqlSession;

	// 게시글 작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVo);
	}

}
