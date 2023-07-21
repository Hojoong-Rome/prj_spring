package com.mycompany.app.infra.mymusicNotice;

import java.util.List;

public interface MyMusicNoticeService {

	public int selectOneCount(MyMusicNoticeVo vo);
	
	public List<MyMusicNotice> selectList(MyMusicNoticeVo vo);
	
	public MyMusicNotice selectOne(MyMusicNoticeVo vo);

	public int selectOneCheckId(MyMusicNoticeVo vo);
	
	public int update(MyMusicNotice dto);
	
	public int delete(MyMusicNotice dto);
	
	public int insert(MyMusicNotice dto);
}