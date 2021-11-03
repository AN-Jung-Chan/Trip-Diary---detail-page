package com.tripdiary.JCcontroller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripdiary.JCservice.ReadService;
import com.tripdiary.JCvo.MemberVo;
import com.tripdiary.JCvo.PickVo;

@Controller
public class PickController {
	
	@Inject
	ReadService service;

	@RequestMapping(value = "/pickClick", method = RequestMethod.GET)
	public String pick(PickVo pickVo, ReadViewCmd readCmd, Model model, HttpSession session) throws Exception {

		// 현재 로그인 멤버 확인
		MemberVo memberVo = (MemberVo) session.getAttribute("memberLoginTest");
		System.out.println("readView(memberVo) : " + memberVo.toString());
		model.addAttribute("memberVo", memberVo);

		// 만약 memberVo가 null이 아니고 member의 memberNum과 readCmd의 boardNum이 같다면 ,
		// 로그인상태에서 동작 확인
		if (memberVo != null && memberVo.getMemberNum() == readCmd.getMemberNum()) {
			System.out.println(memberVo.toString());

			List<PickVo> selectPick = service.selectPick(memberVo.getMemberNum());
			model.addAttribute("selectPick", selectPick);
			// 해당 회원의 memberNum으로 조회한 pick테이블을 List로 가져와서
			// 리스트일때 통째로 비교할때 is empty
			if (!selectPick.isEmpty()) {
				// 안비어있으면 삭제
				service.deletePick(pickVo);
			} else {
				// 비어있으면 insert
				service.insertPick(pickVo);
			}
			System.out.println(selectPick.toString());
		}
		return "redirect:/readView";

	}

}
