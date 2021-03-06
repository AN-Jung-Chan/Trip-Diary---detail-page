package com.tripdiary.JCservice;

import java.util.List;

import com.tripdiary.JCcontroller.MemberActCntCmd;
import com.tripdiary.JCvo.BoardImgVo;
import com.tripdiary.JCvo.MemberVo;
import com.tripdiary.JCvo.PickVo;
import com.tripdiary.JCvo.ReadVo;
import com.tripdiary.JCvo.ReplyCommand;
import com.tripdiary.JCvo.ReplyVo;
import com.tripdiary.JCvo.TagVo;
import com.tripdiary.JCvo.TdLikeVo;

public interface ReadService {

	// 로그인 - 임시
	public MemberVo login(String id) throws Exception;

	// 게시물 목록 조회
	public List<ReadVo> list(ReadVo readVo) throws Exception;

	// 게시물 상세 보기 - 맡은 주 기능
	public ReadVo read(int boardNum) throws Exception;

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

	// 보드 이미지 목록
	public List<BoardImgVo> BoardImgList(int boardNum) throws Exception;

	// 픽 테이블 멤버넘,보드넘 조회
	public PickVo pickCheck(PickVo pickVo) throws Exception;

	// 회원이 상세 게시글 확인 시 pick테이블에 정보가 없다면 눌렀을 때 pick테이블에 추가
	public void insertPick(PickVo pickVo) throws Exception;

	// 회원이 상세 게시글 확인 시 pick테이블에 정보가 있다면 눌렀을 때 pick테이블에 삭제
	public void deletePick(PickVo pickVo) throws Exception;

	// 좋아요 테이블 멤버넘,보드넘 조회
	public TdLikeVo tdLikeCheck(TdLikeVo tdLikeVo) throws Exception;

	// 회원이 상세 게시글 확인 시 좋아요 테이블에 정보가 없다면 눌렀을 때 좋아요 테이블에 추가
	public void insertTdlike(TdLikeVo tdLikeVo) throws Exception;

	// 회원이 상세 게시글 확인 시 좋아요 테이블에 정보가 있다면 눌렀을 때 좋아요 테이블에 삭제
	public void deleteTdlike(TdLikeVo tdLikeVo) throws Exception;

	// 태그 목록
	public List<TagVo> tagList(int boardNum) throws Exception;

	// 카운팅
	public void boardTotalLike(MemberActCntCmd memberActCntCmd) throws Exception;

	// 해당 멤버의 활동 카운팅
	public void memberActCntCmd(MemberActCntCmd memberActCntCmd) throws Exception;

	// 해당 멤버의 댓글 총갯수
	public void replyActCnt(MemberActCntCmd memberActCntCmd) throws Exception;

	// 멤버가 좋아요 받은 총 개수
	public void memberLikeReceiveCnt(MemberActCntCmd memberActCntCmd) throws Exception;

	// 게시글 삭제 후 해당 게시글이 받은 좋아요 횟수 차감
	public void deleteReceiveCnt(MemberActCntCmd memberActCntCmd) throws Exception;
}
