package com.mycompany.app.infra.mymusic;

import java.util.List;

public interface MyMusicService {

	public int selectOneCount(MyMusicVo vo);
	
	public List<MyMusic> selectList(MyMusicVo vo);
	
	public MyMusic selectOne(MyMusicVo vo);

	public int selectOneCheckId(MyMusicVo vo);
	
	public int update(MyMusic dto);
	
	public int delete(MyMusic dto);
	
	public int insert(MyMusic dto);
}