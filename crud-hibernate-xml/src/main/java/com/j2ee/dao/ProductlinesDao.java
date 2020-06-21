package com.j2ee.dao;

import java.util.List;

import com.j2ee.vo.ProductLineVO;

import base.DbException;

public interface ProductlinesDao {

	List<ProductLineVO> selectAll() throws DbException;

	String insert(ProductLineVO productLineVO) throws DbException;

	int update(ProductLineVO productLineVO) throws DbException;

	int delete(ProductLineVO productLineVO) throws DbException;
}
