package com.tripdiary.service;

import java.util.List;

import com.tripdiary.vo.BoardVo;

public interface BoardService {

	// 게시글 작성
	public void write(BoardVo boardVo) throws Exception;

	// 게시물 목록 조회
	public List<BoardVo> list() throws Exception;

}
