package com.tripdiary.dao;

import com.tripdiary.vo.BoardVo;

public interface ReadDao {

	// 게시물 상세 보기 - 맡은 주 기능
	public BoardVo read(int boardNum) throws Exception;

}
