package com.tripdiary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.tripdiary.dao.ReadDao;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCmd;
import com.tripdiary.vo.ReplyVo;

@Repository
public class ReadServiceImpl implements ReadService {

	@Inject
	private ReadDao dao;

	// 게시물 상세 보기 - 맡은 주 기능
	@Override
	public ReadVo read(int boardNum) throws Exception {
		return dao.read(boardNum);
	}

	// 게시물 수정
	@Override
	public void update(ReadVo readVo) throws Exception {
		dao.update(readVo);
	}

	// 게시물 삭제
	@Override
	public void delete(int boardNum) throws Exception {
		dao.delete(boardNum);
	}

	// 댓글 작성
	@Override
	public void replyWrite(ReplyVo replyVo) throws Exception {
		dao.replyWrite(replyVo);
	}

	// 댓글 조회
	@Override
	public List<ReplyCmd> replyList(int boardNum) throws Exception {
		return dao.replyList(boardNum);
	}

	// 댓글 수정
	@Override
	public void replyUpdate(ReplyCmd replyCmd) throws Exception {
		dao.replyUpdate(replyCmd);
	}

	// 댓글 삭제
	@Override
	public void replyDelete(ReplyCmd replyCmd) throws Exception {
		dao.replyDelete(replyCmd);
	}

}
