package com.mycompany.app.infra.mymusicUpload;

import java.util.List;

public interface MyMusicUploadService {

	public int selectOneCount(MyMusicUploadVo vo);
	
	public List<MyMusicUpload> selectList(MyMusicUploadVo vo);
	
	public MyMusicUpload selectOne(MyMusicUploadVo vo);

	public int selectOneCheckId(MyMusicUploadVo vo);
	
	public int update(MyMusicUpload dto);
	
	public int delete(MyMusicUpload dto);
	
	public int insert(MyMusicUpload dto);
}