package com.tripdiary.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.service.BoardService;
import com.tripdiary.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");

	}

	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVo boardVo) throws Exception {
		logger.info("write");

		service.write(boardVo);

		return "redirect:/";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("list");
		
		List<BoardVo> list = service.list();
		System.out.println(list.toString());
		
		model.addAttribute("list", list);

		return "board/list";
	}
}
