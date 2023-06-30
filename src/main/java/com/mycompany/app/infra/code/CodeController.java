package com.mycompany.app.infra.code;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping("/codeList")
	public String codeList(CodeVo vo, Model model) {
		
		List<Code> list = service.selectList(vo);
		
		model.addAttribute("list", list);
		
		return "xdm/infra/code/codeList";
	}
	
	@RequestMapping("/codeForm")
	public String codeForm(CodeVo vo, Model model) {
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "xdm/infra/code/codeForm";
	}
	
	@RequestMapping("/codeUpdt")
	public String codeUpdt(Code dto) {
		service.update(dto);
		
		return "xdm/infra/code/codeList";
	}
	
	
	@RequestMapping("/codeDelete")
	public String codeDelete(Code dto) {
		service.delete(dto);
		
		return "xdm/infra/code/codeList";
	}
	
	@RequestMapping("/codeInsert")
	public String codeInsert(Code dto) {
		service.insert(dto);
		
		return "xdm/infra/code/codeList";
	}
}
