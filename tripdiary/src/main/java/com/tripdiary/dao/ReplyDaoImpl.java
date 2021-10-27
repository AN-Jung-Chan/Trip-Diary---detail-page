package com.tripdiary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.ReplyVo;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Inject
	SqlSession sql;

	// 댓글 조회
	@Override
	public List<ReplyVo> readReply(int boardNum) throws Exception {
		return sql.selectList("replyMapper.readReply", boardNum);
	}

	// 댓글 작성
	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		sql.insert("replyMapper.writeReply", vo);
	}

	// 댓글 수정
	@Override
	public void updateReply(ReplyVo vo) throws Exception {
		sql.update("replyMapper.updateReply", vo);
	}

	// 댓글 삭제
	@Override
	public void deleteReply(ReplyVo vo) throws Exception {
		sql.delete("replyMapper.deleteReply", vo);
	}

	// 선택된 댓글 조회
	@Override
	public ReplyVo selectReply(int replyNum) throws Exception {
		return sql.selectOne("replyMapper.selectReply", replyNum);
	}

}