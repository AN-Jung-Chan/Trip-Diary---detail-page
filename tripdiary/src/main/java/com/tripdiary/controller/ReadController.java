package com.tripdiary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tripdiary.service.ReadService;
import com.tripdiary.vo.MemberVo;
import com.tripdiary.vo.ReadVo;

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
	public String read(Model model, HttpSession session, @RequestParam("boardNum") int boardNum) throws Exception {
		logger.info("read");
		
		
		ReadVo read = service.read(boardNum);
		System.out.println(read.toString());

		model.addAttribute("read", read);

		return "readView";

	}
}
