package com.mycompany.app.infra.codegroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupServiceImpl service;
	
	@RequestMapping("/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
								//HttpServletRequest httpServletRequest, \
		vo.setShKeyword(vo.getShKeyword() == null ? "great" : vo.getShKeyword());
		
		List<CodeGroup> list = service.selectList(vo);
		
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		
		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	@RequestMapping("/codeGroupForm")
	public String codeGroupForm(CodeGroupVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "xdm/infra/codeGroup/codeGroupForm";
	}
	
	@RequestMapping("/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroup dto) {
		service.update(dto);
		
		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	
	@RequestMapping("/codeGroupDelete")
	public String codeGroupDelete(CodeGroup dto) {
		service.delete(dto);
		
		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	@RequestMapping("/codeGroupInsert")
	public String codeGroupInsert(CodeGroup dto) {
		service.insert(dto);
		
		return "xdm/infra/codeGroup/codeGroupList";
	}
}
