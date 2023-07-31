package com.mycompany.app.infra.mymusicUpload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.app.infra.mymusicNotice.MyMusicNoticeVo;

@Controller
public class MyMusicUploadController {


	@Autowired
	MyMusicUploadServiceImpl service;
	
	@RequestMapping("/myMusicUploadList")
	public String myMusicUploadList(@ModelAttribute("vo") MyMusicUploadVo vo, Model model) {
								//HttpServletRequest httpServletRequest, \
		vo.setShKeyword(vo.getShKeyword() == null ? "" : vo.getShKeyword());
		
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if(vo.getTotalRows() > 0) {
			List<MyMusicUpload> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
//			by pass
		}
		
		
		return "usr/infra/mymusic/sub4";
		
		
//		List<CodeGroup> list = service.selectList(vo);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("vo", vo);
//		
//		return "xdm/infra/codeGroup/codeGroupList";
	}
	
	@RequestMapping("/myMusicUploadForm")
	public String myMusicUploadForm(MyMusicUploadVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "usr/infra/mymusic/sub2";
	}
	
	@RequestMapping("/myMusicUploadView")
	public String myMusicUploadView(MyMusicUploadVo vo, Model model) {
								//HttpServletRequest httpServletRequest, 
		
		model.addAttribute("item", service.selectOne(vo));
		
		return "usr/infra/mymusic/sub6";
	}
	
	@RequestMapping("/myMusicUploadUpdt")
	public String myMusicUploadUpdt(MyMusicUpload dto) {
		service.update(dto);
		
		return "usr/infra/mymusic/sub4";
	}
	
	
	@RequestMapping("/myMusicUploadDelete")
	public String myMusicUploadDelete(MyMusicUpload dto) {
		service.delete(dto);
		
		return "usr/infra/mymusic/sub4";
	}
	
	@RequestMapping("/myMusicUploadInsert")
	public String myMusicInsert(MyMusicUpload dto) {
		service.insert(dto);
		
		return "usr/infra/mymusic/sub4";
	}
	
}
