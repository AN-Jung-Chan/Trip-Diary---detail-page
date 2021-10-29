package com.tripdiary.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.service.ReadService;
import com.tripdiary.vo.ReadVo;
import com.tripdiary.vo.ReplyVo;

@Controller
public class ReadController {

	private static final Logger logger = LoggerFactory.getLogger(ReadController.class);

	@Inject
	ReadService service;

	// 게시판 상세 보기 + 댓글CRUD
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(ReadVo readVo, ReplyVo replyVo, Model model) throws Exception {

		logger.info("read");

		System.out.println(readVo.toString());

		model.addAttribute("read", service.read(readVo.getBoardNum()));

		List<ReplyVo> replyList = service.replyList(replyVo.getBoardNum());
		System.out.println(replyList.toString());

		model.addAttribute("replyList", replyList);

		return "readView";
	}

}
