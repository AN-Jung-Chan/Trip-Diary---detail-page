package com.tripdiary.JCservice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.tripdiary.JCdao.ReadDao;
import com.tripdiary.JCvo.BoardImgVo;
import com.tripdiary.JCvo.MemberVo;
import com.tripdiary.JCvo.PickVo;
import com.tripdiary.JCvo.ReadVo;
import com.tripdiary.JCvo.ReplyCommand;
import com.tripdiary.JCvo.ReplyVo;
import com.tripdiary.JCvo.TdLikeVo;

@Repository
public class ReadServiceImpl implements ReadService {

	@Inject
	private ReadDao dao;

	// 로그인 - 임시
	@Override
	public MemberVo login(String id) throws Exception {
		return dao.login(id);
	}

	// 게시물 목록 조회 - 임시
	@Override
	public List<ReadVo> list() throws Exception {
		return dao.list();
	}

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

	// 댓글 조회
	@Override
	public List<ReplyCommand> replyList(int boardNum) throws Exception {
		return dao.replyList(boardNum);
	}

	// 댓글 작성
	@Override
	public void replyWrite(ReplyVo replyVo) throws Exception {
		dao.replyWrite(replyVo);
	}

	// 댓글 수정
	@Override
	public void replyUpdate(ReplyVo replyVo) throws Exception {
		dao.replyUpdate(replyVo);
	}

	// 댓글 삭제
	@Override
	public void replyDelete(ReplyVo replyVo) throws Exception {
		dao.replyDelete(replyVo);
	}

	// 선택된 댓글 조회
	public ReplyVo selectReply(int replyNum) throws Exception {
		return dao.selectReply(replyNum);
	}

	// 보드 이미지 목록
	public List<BoardImgVo> BoardImgList(int boardNum) throws Exception {
		return dao.BoardImgList(boardNum);
	}

	// 픽 테이블 멤버넘,보드넘 조회
	public PickVo pickCheck(PickVo pickVo) throws Exception {
		return dao.pickCheck(pickVo);
	}

	// 회원이 찜하기를 누르지 않은 상태라면 해당 게시물에서 찜하기 추가
	public void insertPick(PickVo pickVo) throws Exception {
		dao.insertPick(pickVo);
	}

	// 회원이 상세 게시글 확인 시 pick테이블에 정보가 있다면 눌렀을 때 pick테이블에 삭제
	public void deletePick(PickVo pickVo) throws Exception {
		dao.deletePick(pickVo);
	}

	// 좋아요 테이블 멤버넘,보드넘 조회
	public TdLikeVo tdLikeCheck(TdLikeVo tdLikeVo) throws Exception {
		return dao.tdLikeCheck(tdLikeVo);
	}

	// 회원이 상세 게시글 확인 시 좋아요 테이블에 정보가 없다면 눌렀을 때 좋아요 테이블에 추가
	public void insertTdlike(TdLikeVo tdLikeVo) throws Exception {
		dao.insertTdlike(tdLikeVo);
	}

	// 회원이 상세 게시글 확인 시 좋아요 테이블에 정보가 있다면 눌렀을 때 좋아요 테이블에 삭제
	public void deleteTdlike(TdLikeVo tdLikeVo) throws Exception {
		dao.deleteTdlike(tdLikeVo);
	}

}
