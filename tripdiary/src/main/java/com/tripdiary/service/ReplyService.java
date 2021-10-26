package com.tripdiary.service;

import java.util.List;

import com.tripdiary.vo.ReplyVo;

public interface ReplyService {

	// 댓글 조회
	public List<ReplyVo> readReply(int boardNum) throws Exception;

	// 댓글 작성
	public void writeReply(ReplyVo vo) throws Exception;

	// 댓글 수정
	public void updateReply(ReplyVo vo) throws Exception;

	// 댓글 삭제
	public void deleteReply(ReplyVo vo) throws Exception;

	// 선택된 댓글 조회
	public ReplyVo selectReply(int replyNum) throws Exception;

}
