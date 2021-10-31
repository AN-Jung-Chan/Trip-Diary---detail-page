package com.tripdiary.service;

import java.util.List;

import com.tripdiary.vo.MemberVo;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCommand;
import com.tripdiary.vo.ReplyVo;

public interface ReadService {

	// 로그인 - 임시
	public MemberVo login(String id) throws Exception;

	// 게시물 목록 조회
	public List<ReadVo> list() throws Exception;

	// 게시물 상세 보기 - 맡은 주 기능
	public ReadVo read(int boardNum) throws Exception;

	// 게시물 수정
	public void update(ReadVo readVo) throws Exception;

	// 게시물 삭제
	public void delete(int boardNum) throws Exception;

	// 댓글 목록
	public List<ReplyCommand> replyList(int boardNum) throws Exception;

	// 댓글 작성
	public void replyWrite(ReplyVo replyVo) throws Exception;

	// 댓글 수정
	public void replyUpdate(ReplyVo replyVo) throws Exception;

	// 댓글 삭제
	public void replyDelete(ReplyVo replyVo) throws Exception;

	// 선택된 댓글 조회
	public ReplyVo selectReply(int replyNum) throws Exception;
}
