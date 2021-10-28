package com.tripdiary.dao;

import java.util.List;

import com.tripdiary.vo.BoardVo;

public interface BoardDao {

	// 게시글 작성
	public void write(BoardVo boardVo) throws Exception;

	// 게시물 목록 조회
	public List<BoardVo> list() throws Exception;

}
