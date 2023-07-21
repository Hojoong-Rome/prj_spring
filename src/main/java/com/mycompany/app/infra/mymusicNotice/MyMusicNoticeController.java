package com.mycompany.app.infra.mymusicNotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyMusicNoticeController {

	@Autowired
	MyMusicNoticeServiceImpl service;
	
	@RequestMapping("/myMusicNoticeList")
	public String myMusicNoticeList(@ModelAttribute("vo") MyMusicNoticeVo vo, Model model) {
								//HttpServletRequest httpServletRequest, \
		vo.setShKeyword(vo.getShKeyword() == null ? "" : vo.getShKeyword());
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			List<MyMusicNotice> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
//			by pass
		}
		
		
		return "usr/infra/mymusic/sub3";
		
		
//		List<CodeGroup> list = service.selectList(vo);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("vo", vo);
//		
//		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	@RequestMapping("/myMusicNoticeForm")
	public String myMusicNoticeForm(MyMusicNoticeVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "usr/infra/mymusic/sub2";
	}
	
	@RequestMapping("/myMusicNoticeUpdt")
	public String myMusicUpdt(MyMusicNotice dto) {
		service.update(dto);
		
		return "usr/infra/mymusic/sub3";
	}
	
	
	@RequestMapping("/myMusicNoticeDelete")
	public String myMusicDelete(MyMusicNotice dto) {
		service.delete(dto);
		
		return "usr/infra/mymusic/sub3";
	}
	
	@RequestMapping("/myMusicNoticeInsert")
	public String myMusicInsert(MyMusicNotice dto) {
		service.insert(dto);
		
		return "usr/infra/mymusic/sub3";
	}
	
}
