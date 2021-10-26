package com.tripdiary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tripdiary.dao.ReplyDao;
import com.tripdiary.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDao dao;

	@Override
	public List<ReplyVo> readReply(int boardNum) throws Exception {
		return dao.readReply(boardNum);
	}

	// 댓글 작성
	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		dao.writeReply(vo);
	}

	// 댓글 수정
	@Override
	public void updateReply(ReplyVo vo) throws Exception {
		dao.updateReply(vo);
	}

	// 댓글 삭제
	@Override
	public void deleteReply(ReplyVo vo) throws Exception {
		dao.deleteReply(vo);
	}

	// 선택된 댓글 조회
	@Override
	public ReplyVo selectReply(int replyNum) throws Exception {
		return dao.selectReply(replyNum);
	}

}
