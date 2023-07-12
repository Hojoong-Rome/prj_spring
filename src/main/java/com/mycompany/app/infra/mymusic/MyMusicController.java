package com.mycompany.app.infra.mymusic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyMusicController {

	@Autowired
	MyMusicServiceImpl service;
	
	@RequestMapping("/myMusicList")
	public String myMusicList(@ModelAttribute("vo") MyMusicVo vo, Model model) {
								//HttpServletRequest httpServletRequest, \
		vo.setShKeyword(vo.getShKeyword() == null ? "" : vo.getShKeyword());
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			List<MyMusic> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
//			by pass
		}
		
		return "usr/infra/mymusic/index";
		
		
//		List<CodeGroup> list = service.selectList(vo);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("vo", vo);
//		
//		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	@RequestMapping("/myMusicForm")
	public String myMusicForm(MyMusicVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "usr/infra/mymusic/index";
	}
	
	@RequestMapping("/myMusicUpdt")
	public String myMusicUpdt(MyMusic dto) {
		service.update(dto);
		
		return "usr/infra/mymusic/index";
	}
	
	
	@RequestMapping("/myMusicDelete")
	public String myMusicDelete(MyMusic dto) {
		service.delete(dto);
		
		return "usr/infra/mymusic/index";
	}
	
	@RequestMapping("/myMusicInsert")
	public String myMusicInsert(MyMusic dto) {
		service.insert(dto);
		
		return "usr/infra/mymusic/index";
	}
}
