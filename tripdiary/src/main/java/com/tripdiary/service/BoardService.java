package com.tripdiary.service;

import com.tripdiary.vo.BoardVo;

public interface BoardService {

	// 게시글 작성
	public void write(BoardVo boardVo) throws Exception;

}
