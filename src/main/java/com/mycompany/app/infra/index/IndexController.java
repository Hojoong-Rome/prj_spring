package com.mycompany.app.infra.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value="/" )
	public String biographyUsrView() {
		// 여기에서 서버 단에서 필요한 작업을 수행한다.
		
		// href="/resources/xdm/v1/css/commonXdm.css"
		
		// 아래 jsp 파일 호출
		return "usr/infra/biography/biographyUsrView";
	}
	
	
	@RequestMapping(value="/adminLogin" )
	public String adminLogin() {
		
		return "xdm/infra/index/adminLogin";
		
	}
	
	@RequestMapping(value="/adminPage" )
	public String adminPage() {
		
		return "xdm/infra/index/adminPage";
		
	}
}