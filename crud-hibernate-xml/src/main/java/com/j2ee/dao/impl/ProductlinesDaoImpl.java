package com.j2ee.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.j2ee.dao.ProductlinesDao;
import com.j2ee.vo.ProductLineVO;

import base.DbException;
import base.DbSession;

public class ProductlinesDaoImpl implements ProductlinesDao {

	private String SELECT_ALL = "FROM ProductLineVO";
	private String UPDATE_BY_ID = "UPDATE ProductLineVO p SET p.textDescription = :textDescVal WHERE p.productLine = :productLineVal";
	private String DELETE_BY_ID = "DELETE ProductLineVO p WHERE p.productLine = :productLinePK";

	@Override
	public List<ProductLineVO> selectAll() throws DbException {
		List<ProductLineVO> productLineVOs = null;
		try {
			Session dbSession = DbSession.sessionStart();
			@SuppressWarnings("unchecked")
			TypedQuery<ProductLineVO> query = dbSession.createQuery(SELECT_ALL);
			productLineVOs = query.getResultList();

			DbSession.sessionEnd();
			return productLineVOs;
		} catch (DbException e) {
			throw new DbException(e + " ::#:: Problem in DB operation");
		}
	}

	@Override
	public String insert(ProductLineVO productLineVO) throws DbException {
		String result = null;
		try {
			Session dbSession = DbSession.sessionStart();
			result = (String) dbSession.save(productLineVO);

			DbSession.sessionEnd();
			return result;
		} catch (DbException e) {
			throw new DbException(e + " ::#:: Problem in DB operation @Customers Insert");
		}
	}

	@Override
	public int update(ProductLineVO productLineVO) throws DbException {
		try {
			int success = -1;
			Session dbSession = DbSession.sessionStart();

			Query query = dbSession.createQuery(UPDATE_BY_ID);

			query.setParameter("textDescVal", productLineVO.getTextDescription());
			query.setParameter("productLineVal", productLineVO.getProductLine());

			success = query.executeUpdate();
			DbSession.sessionEnd();
			return success;
		} catch (Exception e) {
			throw new DbException(e + " ::#:: Problem in DB operation Update");
		}
	}

	@Override
	public int delete(ProductLineVO productLineVO) throws DbException {
		try {
			int success = -1;
			Session dbSession = DbSession.sessionStart();

			Query query = dbSession.createQuery(DELETE_BY_ID);
			query.setParameter("productLinePK", productLineVO.getProductLine());
			success = query.executeUpdate();

			DbSession.sessionEnd();
			return success;
		} catch (Exception e) {
			throw new DbException(e + "::#:: Problem in DB operation delete");
		}
	}

}
