package com.tripdiary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.tripdiary.dao.ReadDao;
import com.tripdiary.vo.BoardVo;

@Repository
public class ReadServiceImpl implements ReadService {

	@Inject
	private ReadDao dao;

	// 게시물 상세 보기 - 맡은 주 기능
	@Override
	public BoardVo read(int boardNum) throws Exception {
		return dao.read(boardNum);
	}

}
