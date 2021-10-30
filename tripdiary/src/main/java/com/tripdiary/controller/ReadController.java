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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tripdiary.service.ReadService;
import com.tripdiary.vo.BoardVo;
import com.tripdiary.vo.MemberVo;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyCmd;
import com.tripdiary.vo.ReplyVo;

@Controller
public class ReadController {

	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

	@Inject
	ReadService service;

	// 메인 - 임시
	@RequestMapping("/")
	public String main() {
		return "home";
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, HttpSession session, RedirectAttributes rttr) throws Exception {

		MemberVo login = service.login(id);

		if (login == null) {
			session.setAttribute("loginMember", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			System.out.println(login.toString());
			session.setAttribute("loginMember", login);
		}

		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("list");

		List<BoardVo> list = service.list();
		System.out.println(list.toString());

		model.addAttribute("list", list);

		return "list";
	}

	// 게시판 상세 보기 + 댓글CRUD
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(ReadVo readVo, Model model) throws Exception {

		logger.info("read");

		System.out.println(readVo.toString());

		model.addAttribute("read", service.read(readVo.getBoardNum()));

		return "readView";
	}

}
