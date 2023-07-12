package com.mycompany.app.infra.mymusic;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyMusicDao {

	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	
	private static String namespace="com.mycompany.app.infra.mymusic.MyMusicMapper";
	
	
	public int selectOneCount(MyMusicVo vo){ return sqlSession.selectOne(namespace + ".selectOneCount", vo); }
	
	public List<MyMusic> selectList(MyMusicVo vo){
		return sqlSession.selectList(namespace + ".selectList", vo);
		}
	
	
	public MyMusic selectOne(MyMusicVo vo) {
		MyMusic myMusic = sqlSession.selectOne(namespace + ".selectOne", vo);
		return myMusic;
	}	
	
	public int update(MyMusic dto) {
		return sqlSession.update(namespace + ".update", dto);
	}
	
	public int delete(MyMusic dto) {
		return sqlSession.delete(namespace + ".delete", dto);
	}
	
	public int insert(MyMusic dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}
}
