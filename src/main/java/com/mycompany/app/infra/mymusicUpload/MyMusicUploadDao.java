package com.mycompany.app.infra.mymusicUpload;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyMusicUploadDao {
	
	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	
	private static String namespace="com.mycompany.app.infra.mymusicUpload.MyMusicUploadMapper";
	
	 public int selectOneCheckId(MyMusicUploadVo vo) {
	    	return sqlSession.selectOne(namespace + ".selectOneCheckId", vo);
	    }
	
	public int selectOneCount(MyMusicUploadVo vo){ return sqlSession.selectOne(namespace + ".selectOneCount", vo); }
	
	public List<MyMusicUpload> selectList(MyMusicUploadVo vo){
		return sqlSession.selectList(namespace + ".selectList", vo);
		}
	
	
	public MyMusicUpload selectOne(MyMusicUploadVo vo) {
		MyMusicUpload myMusicUpload = sqlSession.selectOne(namespace + ".selectOne", vo);
		return myMusicUpload;
	}	
	
	public int update(MyMusicUpload dto) {
		return sqlSession.update(namespace + ".update", dto);
	}
	
	public int delete(MyMusicUpload dto) {
		return sqlSession.delete(namespace + ".delete", dto);
	}
	
	public int insert(MyMusicUpload dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}
	
}
