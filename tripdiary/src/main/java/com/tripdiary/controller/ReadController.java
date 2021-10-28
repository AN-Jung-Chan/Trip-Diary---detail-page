package com.tripdiary.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.service.ReadService;
import com.tripdiary.vo.BoardVo;

@Controller
public class ReadController {

	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

	@Inject
	ReadService service;

	// 게시판 상세 보기
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVo boardVo, Model model) throws Exception {

		logger.info("read");

		System.out.println(boardVo.toString());

		model.addAttribute("read", service.read(boardVo.getBoardNum()));

		return "readView";
	}

}
