package com.mycompany.app.infra.mymusicUpload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyMusicUploadServiceImpl implements MyMusicUploadService {
	
	@Override
	public int selectOneCount(MyMusicUploadVo vo) {
		return dao.selectOneCount(vo);
		
	}
	
	@Override
	public int selectOneCheckId(MyMusicUploadVo vo) {
		// TODO Auto-generated method stub
		return dao.selectOneCheckId(vo);
	}
	
	@Autowired
	MyMusicUploadDao dao;
	
	@Override
	public List<MyMusicUpload> selectList(MyMusicUploadVo vo){return dao.selectList(vo);}

	@Override
	public MyMusicUpload selectOne(MyMusicUploadVo vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(MyMusicUpload dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(MyMusicUpload dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(MyMusicUpload dto) {
		return dao.insert(dto);
	}
	
}
