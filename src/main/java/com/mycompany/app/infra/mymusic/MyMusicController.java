package com.mycompany.app.infra.mymusic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping("/loginProc")
	public Map<String, Object> loginProc(MyMusicVo vo, HttpSession httpSession){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MyMusic rtMyMusic = service.selectOne(vo);
		
		if(rtMyMusic != null) {

			httpSession.setMaxInactiveInterval(60*60); // 60 min
			httpSession.setAttribute("sessionId", vo.getEmail());
			
			returnMap.put("rtMyMusic", rtMyMusic);
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping("/checkIdProc")
	public Map<String,Object> checkIdProc(MyMusicVo vo){
		Map<String,Object> returnMap =new HashMap<String,Object>();
		
		int rtNum = service.selectOneCheckId(vo);
		
		if(rtNum == 0) {
			returnMap.put("rt","available");
			
		}else {
			returnMap.put("rt", "unavailable");
		}
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping("/logoutProc")
	public Map<String, Object>logoutProc(HttpSession httpSession){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}
