package com.tripdiary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.vo.MemberVo;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCommand;
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

	// 댓글 목록
	@Override
	public List<ReplyCommand> replyList(int boardNum) throws Exception {
		return sqlSession.selectList("readMapper.replyList", boardNum);
	}

	// 댓글 작성
	@Override
	public void replyWrite(ReplyVo replyVo) throws Exception {
		sqlSession.insert("readMapper.replyWrite", replyVo);
	}

	// 댓글 수정
	@Override
	public void replyUpdate(ReplyVo replyVo) throws Exception {
		int updateCheck = sqlSession.update("readMapper.replyUpdate", replyVo);
		System.out.println("updateCheck : " + updateCheck);
	}

	// 댓글 삭제
	@Override
	public void replyDelete(ReplyVo replyVo) throws Exception {
		int deleteCheck = sqlSession.delete("readMapper.replyDelete", replyVo);
		System.out.println("deleteCheck : "  + deleteCheck);
	}

	// 선택된 댓글 조회
	public ReplyVo selectReply(int replyNum) throws Exception {
		return sqlSession.selectOne("readMapper.selectReply", replyNum);
	}

}
