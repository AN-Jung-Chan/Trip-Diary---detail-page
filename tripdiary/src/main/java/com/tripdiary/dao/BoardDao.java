package com.tripdiary.dao;

import java.util.List;
import java.util.Map;

import com.tripdiary.vo.BoardVo;
import com.tripdiary.vo.SearchCriteria;

public interface BoardDao {

	// 게시글 작성
	public void write(BoardVo boardVo) throws Exception;

	// 게시물 목록 조회
	public List<BoardVo> list(SearchCriteria scri) throws Exception;

	// 게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;

	// 게시물 조회
	public BoardVo read(int boardNum) throws Exception;

	// 게시물 수정
	public void update(BoardVo boardVo) throws Exception;

	// 게시물 삭제
	public void delete(int boardNum) throws Exception;

	// 첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int boardNum) throws Exception;

	// 첨부파일 다운
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;

	// 첨부파일 수정
	public void updateFile(Map<String, Object> map) throws Exception;

	// 게시판 조회수
	public void boardHit(int boardNum) throws Exception;

}
