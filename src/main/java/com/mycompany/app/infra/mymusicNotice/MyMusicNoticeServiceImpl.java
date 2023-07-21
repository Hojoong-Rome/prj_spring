package com.mycompany.app.infra.mymusicNotice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyMusicNoticeServiceImpl implements MyMusicNoticeService {

	@Override
	public int selectOneCount(MyMusicNoticeVo vo) {
		return dao.selectOneCount(vo);
		
	}
	
	@Override
	public int selectOneCheckId(MyMusicNoticeVo vo) {
		// TODO Auto-generated method stub
		return dao.selectOneCheckId(vo);
	}
	
	@Autowired
	MyMusicNoticeDao dao;
	
	@Override
	public List<MyMusicNotice> selectList(MyMusicNoticeVo vo){return dao.selectList(vo);}

	@Override
	public MyMusicNotice selectOne(MyMusicNoticeVo vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(MyMusicNotice dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(MyMusicNotice dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(MyMusicNotice dto) {
		return dao.insert(dto);
	}

	
	
}
