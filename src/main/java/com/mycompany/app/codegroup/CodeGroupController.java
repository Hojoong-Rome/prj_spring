package com.mycompany.app.codegroup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupServiceImpl service;
	
	@RequestMapping("/codeGroupList")
	public String codeGroupList(CodeGroupVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		List<CodeGroup> list = service.selectList(vo);
		
		model.addAttribute("list", list);
		
		return "codeGroupList";
	}
	
	@RequestMapping("/codeGroupForm")
	public String codeGroupForm(CodeGroupVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		CodeGroup codeGroup = service.selectOne(vo);
		
		model.addAttribute("item", codeGroup);
		
		return "codeGroupForm3";
	}
	
}
