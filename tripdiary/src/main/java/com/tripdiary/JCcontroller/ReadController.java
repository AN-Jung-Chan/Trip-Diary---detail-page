package com.tripdiary.JCcontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.JCservice.ReadService;
import com.tripdiary.JCvo.BoardImgVo;
import com.tripdiary.JCvo.MemberVo;
import com.tripdiary.JCvo.PickVo;
import com.tripdiary.JCvo.ReadVo;
import com.tripdiary.JCvo.ReplyCommand;
import com.tripdiary.JCvo.ReplyVo;
import com.tripdiary.JCvo.TagVo;
import com.tripdiary.JCvo.TdLikeVo;

@Controller
public class ReadController {

	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

	@Inject
	ReadService service;

	// 세션 확인용 로그인 테스트 코드 : 삭제해야됨 : 시작
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signInGet() {
		return "signIn";
	}

	// 로그인 테스트
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signInPost(String id, String password, HttpSession session) throws Exception {

		MemberVo memberLoginTest = service.login(id);

		if (memberLoginTest.getPassword().equals(password)) {
			session.setAttribute("memberLoginTest", memberLoginTest);
			return "redirect:/list";
		} else {
			return "signIn";
		}
	}

	// 로그아웃
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public String signOutGet(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	// 세션 확인용 로그인 테스트 코드 : 삭제해야됨 : 끝

	// 게시판 목록 조회 - 임시
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ReadVo readVo, Model model, HttpSession session) throws Exception {
		logger.info("list");

		// 로그인시 memberVo 에 로그인 회원 memberNum 셋팅
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");

		// 만약 memberVo에 정보에 있다면 memberVo 사용가능
		if (memberVo != null) {
			System.out.println(memberVo);

			// 동시에 readVo의 정보 전체를 List로 값 셋팅 - 사용가능
			List<ReadVo> list = service.list(readVo);
			System.out.println(list.toString());

			model.addAttribute("list", list);
		}
		return "list";
	}

	// 게시판 상세 보기 + 댓글 목록
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(ReadVo readVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {
		logger.info("read");

		System.out.println(readCmd.toString());

		// 현재 로그인 멤버 확인
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("readView(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 게시글 목록 - boardNum, memberNum, nickname, profileVo
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 해당 게시글 댓글 목록 - replyVo, nickname
		List<ReplyCommand> replyList = service.replyList(readCmd.getBoardNum());
		System.out.println(replyList.toString());
		model.addAttribute("replyList", replyList);

		// 보드 이미지 목록
		List<BoardImgVo> boardImgList = service.BoardImgList(read.getBoardNum());
		System.out.println(boardImgList.toString());
		model.addAttribute("boardImgList", boardImgList);

		// 태그
		List<TagVo> tagList = service.tagList(read.getBoardNum());
		System.out.println("tagList : " + tagList.toString());
		model.addAttribute("tagList", tagList);

		// 찜 회원 확인
		PickVo pickVo = new PickVo(memberVo.getMemberNum(), readCmd.getBoardNum());
		System.out.println("pickVo : " + pickVo.toString());

		PickVo pickCheck = service.pickCheck(pickVo);

		if (pickCheck == null) {
			System.out.println("pickCheck 없음");
		} else {
			System.out.println("pickCheck : " + pickCheck.toString());
		}

		model.addAttribute("pickCheck", pickCheck);

		// 좋아요 회원 확인
		TdLikeVo tdLikeVo = new TdLikeVo(memberVo.getMemberNum(), readCmd.getBoardNum());
		System.out.println("tdLikeVo : " + tdLikeVo.toString());

		TdLikeVo tdLikeCheck = service.tdLikeCheck(tdLikeVo);

		if (tdLikeCheck == null) {
			System.out.println("tdLikeCheck 없음");
		} else {
			System.out.println("tdLikeCheck : " + tdLikeCheck.toString());
		}

		model.addAttribute("tdLikeCheck", tdLikeCheck);

		return "readView";
	}

	// 게시글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(ReadVo readVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {

		logger.info("delete");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("tdLikeCnt 활용할 read", read);

		// 현재 로그인 된 회원인지 아닌지 파악 후 본인글이면 삭제진행, 아니면 본인 게시글이 아니라는 안내멘트
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");

		MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readVo.getBoardNum(), readVo.getBoardMemberNum(),
				memberVo.getMemberNum(), "deleteBoard");

		if (memberVo != null) {
			System.out.println("delete(memberVo) : " + memberVo.toString());
			model.addAttribute("memberVo", memberVo);
			
			service.delete(readCmd.getBoardNum());
			
			memberActCntCmd.setTdLikeCnt(read.getTdLikeCnt());
			memberActCntCmd.setUpdateType("delete");
			service.deleteReceiveCnt(memberActCntCmd);
			System.out.println("deleteReceiveCnt :memberActCntCmd.delete : " + memberActCntCmd.toString());
		}
		return "redirect:/list";
	}

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVo replyVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {
		logger.info("reply Write");

		System.out.println("작성하고 난 후 : " + readCmd.toString());

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("replyWrite(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readCmd.getBoardNum(), readCmd.getMemberNum(),
				memberVo.getMemberNum(), "reply");

		// 작성
		service.replyWrite(replyVo);
		System.out.println(replyVo.toString());

		memberActCntCmd.setUpdateType("insert");
		service.replyActCnt(memberActCntCmd);
		System.out.println("reply :memberActCntCmd.insert : " + memberActCntCmd.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

	// 댓글 수정 GET
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public String getReplyUpdate(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session)
			throws Exception {
		logger.info("reply Update");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("replyUpdate(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		System.out.println("replyUpdate,replyVo : " + replyVo.toString());
		ReplyVo replyVoCheck = service.selectReply(replyVo.getReplyNum());
		System.out.println(replyVoCheck.toString());

		// 수정하기위해 replyVo에서 정보 가져오기
		model.addAttribute("selectReply", replyVoCheck);

		return "replyUpdate";
	}

	// 댓글 수정 POST
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session) throws Exception {
		logger.info("reply Update");

		System.out.println("replyUpdate,ㄷㄹㅇ");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println(memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 댓글 작성 업데이트
		service.replyUpdate(replyVo);
		System.out.println(replyVo.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

	// 댓글 삭제 POST
	@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
	public String replyDelete(ReplyVo replyVo, Model model, ReadViewCmd readCmd, HttpSession session) throws Exception {
		logger.info("reply Delete");

		System.out.println("replyDelete 들어왔다");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(readCmd.getBoardNum());
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println(memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 댓글 삭제 업데이트
		MemberActCntCmd memberActCntCmd = new MemberActCntCmd(readCmd.getBoardNum(), readCmd.getMemberNum(),
				memberVo.getMemberNum(), "reply");

		service.replyDelete(replyVo);
		System.out.println(replyVo.toString());

		memberActCntCmd.setUpdateType("delete");
		System.out.println("reply : memberActCntCmd.insert : " + memberActCntCmd.toString());

		service.replyActCnt(memberActCntCmd);

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

}
