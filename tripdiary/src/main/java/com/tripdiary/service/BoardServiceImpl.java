package com.tripdiary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.dao.BoardDao;
import com.tripdiary.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDao dao;

	// 게시글 작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		dao.write(boardVo);
	}

}
