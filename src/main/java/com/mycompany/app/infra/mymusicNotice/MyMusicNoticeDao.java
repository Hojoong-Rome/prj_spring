package com.mycompany.app.infra.mymusicNotice;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyMusicNoticeDao {

	@Inject
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	
	private static String namespace="com.mycompany.app.infra.mymusicNotice.MyMusicNoticeMapper";
	
	 public int selectOneCheckId(MyMusicNoticeVo vo) {
	    	return sqlSession.selectOne(namespace + ".selectOneCheckId", vo);
	    }
	
	public int selectOneCount(MyMusicNoticeVo vo){ return sqlSession.selectOne(namespace + ".selectOneCount", vo); }
	
	public List<MyMusicNotice> selectList(MyMusicNoticeVo vo){
		return sqlSession.selectList(namespace + ".selectList", vo);
		}
	
	
	public MyMusicNotice selectOne(MyMusicNoticeVo vo) {
		MyMusicNotice myMusicNotice = sqlSession.selectOne(namespace + ".selectOne", vo);
		return myMusicNotice;
	}	
	
	public int update(MyMusicNotice dto) {
		return sqlSession.update(namespace + ".update", dto);
	}
	
	public int delete(MyMusicNotice dto) {
		return sqlSession.delete(namespace + ".delete", dto);
	}
	
	public int insert(MyMusicNotice dto) {
		return sqlSession.insert(namespace + ".insert", dto);
	}
}
