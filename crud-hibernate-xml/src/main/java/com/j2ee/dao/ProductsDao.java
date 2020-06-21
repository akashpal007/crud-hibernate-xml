package com.j2ee.dao;

import java.util.List;

import com.j2ee.vo.ProductVO;

import base.DbException;

public interface ProductsDao {
	List<ProductVO> selectAll() throws DbException;

	String insert(ProductVO productVO) throws DbException;

	int update(ProductVO productVO) throws DbException;

	int delete(ProductVO productVO) throws DbException;

}
