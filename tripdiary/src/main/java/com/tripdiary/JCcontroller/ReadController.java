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
	public String list(Model model, HttpSession session) throws Exception {
		logger.info("list");
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");

		if (memberVo != null) {
			System.out.println(memberVo);
			List<ReadVo> list = service.list();
			System.out.println(list.toString());

			model.addAttribute("list", list);
		}
		return "list";
	}

	// 게시판 상세 보기 + 댓글 목록
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(PickVo pickVo, int boardNum, Model model, HttpSession session) throws Exception {
		logger.info("read");

		System.out.println(boardNum);

		// 게시글 목록 - boardNum, memberNum, nickname, profileVo
		ReadVo read = service.read(boardNum);
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("readView(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 해당 게시글 댓글 목록 - replyVo, nickname
		List<ReplyCommand> replyList = service.replyList(boardNum);
		System.out.println(replyList.toString());
		model.addAttribute("replyList", replyList);

		// 보드 이미지 목록
		List<BoardImgVo> boardImgList = service.BoardImgList(boardNum);
		System.out.println(boardImgList.toString());
		model.addAttribute("boardImgList", boardImgList);

		// 회원 번호와 게시글 번호를 통해 픽테이블 조회
		if (memberVo != null && memberVo.getMemberNum() == pickVo.getMemberNum()) {
			// 회원이 로그인된 상태이고 로그인한 회원과 찜하기를 누른 회원이 같은지 검사 후 같다면 동작
			System.out.println(memberVo.toString());

			PickVo selectPick = service.selectPick(pickVo);
			model.addAttribute("selectPick", selectPick);
			// read에서 가져온 pickVo에 해당하는 정보가 Pick테이블에 존재하는지 확인
			// 게시글 열람했을 때 만약 pick테이블에서 조회가 안되면 찜하기 안누른 회원
			// 게시글 열람했을 때 만약 pick테이블에서 조회가 된다면 찜하기 누른 회원

			if (selectPick == null) {
				service.insertPick(pickVo);
				model.addAttribute("insertPick", selectPick);

			} else {
				service.deletePick(pickVo);
				model.addAttribute("deletePick", selectPick);
			}

			System.out.println(selectPick.toString()); // null일때는 투스트링 찍을 수 없기에 검사 의미 x, Dead code

		}

		return "readView";

	}

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVo replyVo, Model model, int boardNum, HttpSession session) throws Exception {
		logger.info("reply Write");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(boardNum);
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("replyWrite(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 작성
		service.replyWrite(replyVo);
		System.out.println(replyVo.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

	// 댓글 수정 GET
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public String getReplyUpdate(ReplyVo replyVo, Model model, int boardNum, HttpSession session) throws Exception {
		logger.info("reply Update");

		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(boardNum);
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
	public String replyUpdate(ReplyVo replyVo, Model model, int boardNum, HttpSession session) throws Exception {
		logger.info("reply Update");
		System.out.println("replyUpdate,ㄷㄹㅇ");
		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(boardNum);
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
	public String replyDelete(ReplyVo replyVo, Model model, int boardNum, HttpSession session) throws Exception {
		logger.info("reply Delete");
		System.out.println("replyDelete 들어왔다");
		// hidden에 들어가는거 - 삭제해야하나??
		ReadVo read = service.read(boardNum);
		System.out.println(read.toString());
		model.addAttribute("read", read);

		// 현재 로그인 멤버 확인 - 삭제해야함
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println(memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 댓글 삭제 업데이트
		service.replyDelete(replyVo);
		System.out.println(replyVo.toString());

		return "redirect:/readView?boardNum=" + replyVo.getBoardNum();
	}

}
