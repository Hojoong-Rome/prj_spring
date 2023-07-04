package com.mycompany.app.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.infra.member.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public int selectOneCount(MemberVo vo) {
		return dao.selectOneCount(vo);
	}
	
	@Autowired
	MemberDao dao;
	
	@Override
	public List<Member> selectList(MemberVo vo){return dao.selectList(vo);}

	@Override
	public Member selectOne(MemberVo vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(Member dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(Member dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(Member dto) {
		return dao.insert(dto);
	}
	
}
