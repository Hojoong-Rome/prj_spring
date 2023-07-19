package com.mycompany.app.infra.code;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

	@Override
	public int selectOneCount(CodeVo vo) {
		return dao.selectOneCount(vo);
	}
	
	@Autowired
	CodeDao dao;
	
	@Override
	public List<Code> selectList(CodeVo vo){return dao.selectList(vo);}

	@Override
	public Code selectOne(CodeVo vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(Code dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(Code dto) {
		return dao.delete(dto);
	}
	
	@Override
	public int insert(Code dto) {
		return dao.insert(dto);
	}
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception{
		List<Code> codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		Code.cachedCodeArrayList.clear();
		Code.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList" + " = " + Code.cachedCodeArrayList.size());
		
	}
	
	public static void clear() throws Exception{
		Code.cachedCodeArrayList.clear();
	}
	
	public static List<Code> selectListCachedCode(String seq) throws Exception{
		List<Code> rt = new ArrayList<Code>();
		for(Code codeRow : Code.cachedCodeArrayList) {
			if(codeRow.getSeq().equals(seq)) {
				rt.add(codeRow);
			} else {
			//  bypass
			}
		}
		
		return rt;
	}
	
	public static String selectOneCachedCode(int code) throws Exception{
		String rt = "";
		for(Code codeRow : Code.cachedCodeArrayList) {
			if(codeRow.getSeq().equals(Integer.toString(code))) {
				rt = codeRow.getName();
			} else {
			//  bypass
			}
		}
		
		return rt;
	}
}
