package com.mycompany.app.infra.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping("/memberList")
	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) {
								//HttpServletRequest httpServletRequest, \
		vo.setShKeyword(vo.getShKeyword() == null ? "" : vo.getShKeyword());
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			List<Member> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
//			by pass
		}

		return "xdm/infra/member/memberList";
		
	}
	
	
	@RequestMapping("/memberForm")
	public String memberForm(MemberVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "xdm/infra/member/memberForm";
	}
	
	@RequestMapping("/memberUpdt")
	public String memberUpdt(Member dto) {
		service.update(dto);
		
		return "xdm/infra/member/memberList";
	}
	
	
	@RequestMapping("/memberDelete")
	public String memberDelete(Member dto) {
		service.delete(dto);
		
		return "xdm/infra/member/memberList";
	}
	
	@RequestMapping("/memberInsert")
	public String memberInsert(Member dto) {
		service.insert(dto);
		
		return "xdm/infra/member/memberList";
	}
}
