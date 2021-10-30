package com.tripdiary.service;

import java.util.List;

import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCmd;
import com.tripdiary.vo.ReplyVo;

public interface ReadService {

	// 게시물 상세 보기 - 맡은 주 기능
	public ReadVo read(int boardNum) throws Exception;

	// 게시물 수정
	public void update(ReadVo readVo) throws Exception;

	// 게시물 삭제
	public void delete(int boardNum) throws Exception;

	// 댓글 작성
	public void replyWrite(ReplyVo replyVo) throws Exception;

	// 댓글 목록
	public List<ReplyCmd> replyList(int boardNum) throws Exception;

	// 댓글 수정
	public void replyUpdate(ReplyCmd replyCmd) throws Exception;

	// 댓글 삭제
	public void replyDelete(ReplyCmd replyCmd) throws Exception;
}
