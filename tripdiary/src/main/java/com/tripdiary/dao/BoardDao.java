package com.tripdiary.dao;

import com.tripdiary.vo.BoardVo;

public interface BoardDao {

	// 게시글 작성
	public void write(BoardVo boardVo) throws Exception;

}
