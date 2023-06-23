package com.mycompany.app.codegroup;

public class CodeGroup {
	
	// DB Column 첫 글자는 소문자로
	// seq는 편의상 DB에는 int 타입, Java에선 String 타입으로 사용
	// 테이블의 Column명과 일치
	
	private String seq;
	private String name;
	
	// -----
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
