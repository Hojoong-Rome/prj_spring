package com.mycompany.app.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupServiceImpl service;
	
	@RequestMapping("/codeGroupList")
	public String codeGroupList(Model model) {
		
		List<CodeGroup> list = service.selectList();
		
		model.addAttribute("list", list);
		
		return "codeGroupList";
	}
	
	
}
