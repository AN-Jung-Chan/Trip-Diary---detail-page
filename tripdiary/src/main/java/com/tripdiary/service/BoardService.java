package com.tripdiary.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.vo.BoardVo;
import com.tripdiary.vo.SearchCriteria;

public interface BoardService {

	// 게시글 작성
	public void write(BoardVo boardVo, MultipartHttpServletRequest mpRequest) throws Exception;

	// 게시물 목록 조회
	public List<BoardVo> list(SearchCriteria scri) throws Exception;

	// 게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;

	// 게시물 목록 조회
	public BoardVo read(int boardNum) throws Exception;

	// 게시물 수정
	public void update(BoardVo boardVo, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest)
			throws Exception;

	// 게시물 삭제
	public void delete(int boardNum) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int boardNum) throws Exception;

	// 첨부파일 다운
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;

}
