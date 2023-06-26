package com.mycompany.app.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping("/codeList")
	public String CodeList(Model model) {
		
		List<Code> list = service.selectList();
		model.addAttribute("list", list);
		
		return "codeList";
	}
	
}
