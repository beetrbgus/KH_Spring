package com.kh.spring23.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring23.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<ProductDto> list() {
		return sqlsession.selectList("list");
	}

	@Override
	public List<ProductDto> search(List<Integer> no) {
		
		Map<String,Object> param = new HashMap<>();
		param.put("list", no);
		return sqlsession.selectList("search" , param );
	}
	
}
