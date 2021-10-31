package com.tripdiary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.MemberVo;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCmd;
import com.tripdiary.vo.ReplyVo;

@Repository
public class ReadDaoImpl implements ReadDao {

	@Inject
	private SqlSession sqlSession;

	// 로그인 - 임시
	@Override
	public MemberVo login(String id) throws Exception {
		return sqlSession.selectOne("readMapper.login", id);
	}

	// 게시글 목록 조회 - 임시
	@Override
	public List<ReadVo> list() throws Exception {
		return sqlSession.selectList("readMapper.list");
	}

	// 게시물 상세 보기 - 맡은 주 기능
	@Override
	public ReadVo read(int boardNum) throws Exception {
		return sqlSession.selectOne("readMapper.read", boardNum);
	}

	// 게시물 수정
	@Override
	public void update(ReadVo readVo) throws Exception {

		sqlSession.update("readMapper.update", readVo);
	}

	// 게시물 삭제
	@Override
	public void delete(int boardNum) throws Exception {

		sqlSession.delete("readMapper.delete", boardNum);
	}

	// 댓글 작성
	@Override
	public void replyWrite(ReplyVo replyVo) throws Exception {
		sqlSession.insert("readMapper.replyWrite", replyVo);
	}

	// 댓글 조회
	@Override
	public List<ReplyCmd> replyList(int boardNum) throws Exception {
		return sqlSession.selectList("readMapper.replyList", boardNum);
	}

	// 댓글 수정
	@Override
	public void replyUpdate(ReplyCmd replyCmd) throws Exception {
		sqlSession.update("readMapper.replyUpdate", replyCmd);
	}

	// 댓글 삭제
	@Override
	public void replyDelete(ReplyCmd replyCmd) throws Exception {
		sqlSession.delete("readMapper.replyDelete", replyCmd);
	}

}
