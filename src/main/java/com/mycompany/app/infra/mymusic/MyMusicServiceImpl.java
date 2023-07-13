package com.mycompany.app.infra.mymusic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyMusicServiceImpl implements MyMusicService {

	@Override
	public int selectOneCount(MyMusicVo vo) {
		return dao.selectOneCount(vo);
		
	}
	
	@Override
	public int selectOneCheckId(MyMusicVo vo) {
		// TODO Auto-generated method stub
		return dao.selectOneCheckId(vo);
	}
	
	@Autowired
	MyMusicDao dao;
	
	@Override
	public List<MyMusic> selectList(MyMusicVo vo){return dao.selectList(vo);}

	@Override
	public MyMusic selectOne(MyMusicVo vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(MyMusic dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(MyMusic dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(MyMusic dto) {
		return dao.insert(dto);
	}

	
	
}
