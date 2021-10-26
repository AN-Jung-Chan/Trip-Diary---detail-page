package com.tripdiary.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tripdiary.dao.BoardDao;
import com.tripdiary.util.FileUtils;
import com.tripdiary.vo.BoardVo;
import com.tripdiary.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Inject
	private BoardDao dao;

	// 게시글 작성
	@Override
	public void write(BoardVo boardVo, MultipartHttpServletRequest mpRequest) throws Exception {
		dao.write(boardVo);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardVo, mpRequest);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			dao.insertFile(list.get(i));
		}
	}

	// 게시물 목록 조회
	@Override
	public List<BoardVo> list(SearchCriteria scri) throws Exception {
		return dao.list(scri);
	}

	// 게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception {
		return dao.listCount(scri);
	}

	// 게시물 상세 페이지
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVo read(int boardNum) throws Exception {
		dao.boardHit(boardNum);
		return dao.read(boardNum);
	}

	// 게시물 수정
	@Override
	public void update(BoardVo boardVo, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest)
			throws Exception {

		dao.update(boardVo);

		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVo, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			} else {
				dao.updateFile(tempMap);
			}
		}
	}

	@Override
	public void delete(int boardNum) throws Exception {

		dao.delete(boardNum);
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int boardNum) throws Exception {
		return dao.selectFileList(boardNum);
	}

	// 첨부파일 다운로드
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return dao.selectFileInfo(map);
	}

}
