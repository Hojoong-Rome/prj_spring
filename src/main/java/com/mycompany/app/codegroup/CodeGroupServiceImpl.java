package com.mycompany.app.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {

	@Autowired
	CodeGroupDao dao;
	
	@Override
	public List<CodeGroup> selectList(CodeGroupVo vo){return dao.selectList(vo);}

	@Override
	public CodeGroup selectOne(CodeGroupVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(CodeGroup dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(CodeGroup dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(CodeGroup dto) {
		return dao.insert(dto);
	}
	
}
