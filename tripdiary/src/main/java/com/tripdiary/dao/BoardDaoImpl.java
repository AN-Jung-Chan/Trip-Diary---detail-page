package com.tripdiary.dao;

import java.util.List;
import java.util.Map;

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

	// 게시물 목록 조회
	@Override
	public List<BoardVo> list(SearchCriteria scri) throws Exception {
		return sqlSession.selectList("boardMapper.listPage", scri);
	}

	@Override
	// 게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSession.selectOne("boardMapper.listCount", scri);
	}

	// 게시물 조회
	@Override
	public BoardVo read(int boardNum) throws Exception {
		return sqlSession.selectOne("boardMapper.read", boardNum);
	}

	// 게시물 수정
	@Override
	public void update(BoardVo boardVo) throws Exception {

		sqlSession.update("boardMapper.update", boardVo);
	}

	// 게시물 삭제
	@Override
	public void delete(int boardNum) throws Exception {

		sqlSession.delete("boardMapper.delete", boardNum);
	}

	// 첨부파일 업로드
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		sqlSession.insert("boardMapper.insertFile", map);
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int boardNum) throws Exception {
		return sqlSession.selectList("boardMapper.selectFileList", boardNum);
	}

	// 첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne("boardMapper.selectFileInfo", map);
	}

	// 첨부파일 수정
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {

		sqlSession.update("boardMapper.updateFile", map);
	}

	@Override
	public void boardHit(int boardNum) throws Exception {
		sqlSession.update("boardMapper.boardHit", boardNum);
	}

}
