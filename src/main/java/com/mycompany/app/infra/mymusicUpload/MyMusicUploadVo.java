package com.mycompany.app.infra.mymusicUpload;

public class MyMusicUploadVo {
	
	private Integer shOption;
	private String shKeyword;
	
	private String seq;
	private Integer number;
	private String header;
	private String article;
	private String writer;
	private String date;
	private String requestOrUpload;
	private String rightOrLeft;
	private String requestNotice_seq;
	private String delNy;
	
	private int thisPage = 1;
	
	private int rowNumToShow = 7;
	private int pageNumToShow = 5;
	
	private int totalRows;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	private int startRnumForOracle = 1;
	private int endRnumForOracle;
	private Integer RNUM;
	
	private int startRnumForMysql = 0;

	
	
	
	
	public Integer getShOption() {
		return shOption;
	}

	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}

	public String getShKeyword() {
		return shKeyword;
	}

	public void setShKeyword(String shKeyword) {
		this.shKeyword = shKeyword;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRequestOrUpload() {
		return requestOrUpload;
	}

	public void setRequestOrUpload(String requestOrUpload) {
		this.requestOrUpload = requestOrUpload;
	}

	public String getRightOrLeft() {
		return rightOrLeft;
	}

	public void setRightOrLeft(String rightOrLeft) {
		this.rightOrLeft = rightOrLeft;
	}

	public String getRequestNotice_seq() {
		return requestNotice_seq;
	}

	public void setRequestNotice_seq(String requestNotice_seq) {
		this.requestNotice_seq = requestNotice_seq;
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public int getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartRnumForOracle() {
		return startRnumForOracle;
	}

	public void setStartRnumForOracle(int startRnumForOracle) {
		this.startRnumForOracle = startRnumForOracle;
	}

	public int getEndRnumForOracle() {
		return endRnumForOracle;
	}

	public void setEndRnumForOracle(int endRnumForOracle) {
		this.endRnumForOracle = endRnumForOracle;
	}

	public Integer getRNUM() {
		return RNUM;
	}

	public void setRNUM(Integer rNUM) {
		RNUM = rNUM;
	}

	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	public String getDelNy() {
		return delNy;
	}

	public void setDelNy(String delNy) {
		this.delNy = delNy;
	}
	
	
	//========================================
	
	

	public void setParamsPaging(int totalRows) {
		
//		setThisPage(3);
	
			setTotalRows(totalRows);
	
			if (getTotalRows() == 0) {
				setTotalPages(1);
			} else {
				setTotalPages(getTotalRows() / getRowNumToShow());
			}
	
			if (getTotalRows() % getRowNumToShow() > 0) {
				setTotalPages(getTotalPages() + 1);
			}
	
			if (getTotalPages() < getThisPage()) {
				setThisPage(getTotalPages());
			}
			
			setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);
	
			setEndPage(getStartPage() + getPageNumToShow() - 1);
	
			if (getEndPage() > getTotalPages()) {
				setEndPage(getTotalPages());
			}
			
			setEndRnumForOracle((getRowNumToShow() * getThisPage()));
			setStartRnumForOracle((getEndRnumForOracle() - getRowNumToShow()) + 1);
			if (getStartRnumForOracle() < 1) setStartRnumForOracle(1);
			
			if (thisPage == 1) {
				setStartRnumForMysql(0);
			} else {
				setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
			}
			
			System.out.println("getThisPage():" + getThisPage());
			System.out.println("getTotalRows():" + getTotalRows());
			System.out.println("getRowNumToShow():" + getRowNumToShow());
			System.out.println("getTotalPages():" + getTotalPages());
			System.out.println("getStartPage():" + getStartPage());
			System.out.println("getEndPage():" + getEndPage());		
			System.out.println("getStartRnumForOracle():" + getStartRnumForOracle());
			System.out.println("getEndRnumForOracle():" + getEndRnumForOracle());
			System.out.println("getStartRnumForMysql(): " + getStartRnumForMysql());
			
		}
}
