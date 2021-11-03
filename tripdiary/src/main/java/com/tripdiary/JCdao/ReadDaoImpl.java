package com.tripdiary.JCdao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tripdiary.JCvo.BoardImgVo;
import com.tripdiary.JCvo.MemberVo;
import com.tripdiary.JCvo.PickVo;
import com.tripdiary.JCvo.ReadVo;
import com.tripdiary.JCvo.ReplyCommand;
import com.tripdiary.JCvo.ReplyVo;

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
		System.out.println("deleteCheck : " + deleteCheck);
	}

	// 선택된 댓글 조회
	public ReplyVo selectReply(int replyNum) throws Exception {
		return sqlSession.selectOne("readMapper.selectReply", replyNum);
	}

	// 보드 이미지 목록
	public List<BoardImgVo> BoardImgList(int boardNum) throws Exception {
		return sqlSession.selectList("readMapper.boardImgList", boardNum);
	}

	// 픽테이블 멤버번호로 조회
	public List<PickVo> selectPick(int memberNum) throws Exception {
		return sqlSession.selectList("readMapper.selectPick", memberNum);
	}

	// 픽 테이블 멤버넘,보드넘 조회
	public PickVo pickCheck(PickVo pickVo) throws Exception {
		return sqlSession.selectOne("readMapper.pickCheck", pickVo);
	}

	// 회원이 찜하기를 누르지 않은 상태라면 해당 게시물에서 찜하기 추가
	public void insertPick(PickVo pickVo) throws Exception {
		sqlSession.insert("readMapper.insertPick", pickVo);
	}

	// 회원이 상세 게시글 확인 시 pick테이블에 정보가 있다면 눌렀을 때 pick테이블에 삭제
	public void deletePick(PickVo pickVo) throws Exception {
		sqlSession.delete("readMapper.deletePick", pickVo);
	}
}
