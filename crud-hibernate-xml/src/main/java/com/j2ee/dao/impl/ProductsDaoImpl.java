package com.j2ee.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.j2ee.dao.ProductsDao;
import com.j2ee.vo.ProductVO;

import base.DbException;
import base.DbSession;

public class ProductsDaoImpl implements ProductsDao {
	private String SELECT_ALL = "FROM ProductVO";
	private String UPDATE_BY_ID = "UPDATE ProductVO p SET p.productName = :productNameVal, p.productLine = :productLineVal, p.productScale = :productScaleVal,\n"
			+ " p.productVendor = :productVendorVal, p.productDescription = :productDescriptionVal, p.quantityInStock = :quantityInStockVal,\n"
			+ " p.buyPrice = :buyPriceVal,p.MSRP = :MSRPVal WHERE p.productCode = :productCodeVal";
	private String DELETE_BY_ID = "DELETE ProductVO p WHERE p.productCode = :productCodeVal";

	@Override
	public List<ProductVO> selectAll() throws DbException {
		List<ProductVO> productVOs = null;
		try {
			Session dbSession = DbSession.sessionStart();
			@SuppressWarnings("unchecked")
			TypedQuery<ProductVO> query = dbSession.createQuery(SELECT_ALL);
			productVOs = query.getResultList();

			DbSession.sessionEnd();
			return productVOs;
		} catch (DbException e) {
			throw new DbException(e + " ::#:: Problem in DB operation");
		}
	}

	@Override
	public String insert(ProductVO productVO) throws DbException {
		String result = null;
		try {
			Session dbSession = DbSession.sessionStart();
			result = (String) dbSession.save(productVO);

			DbSession.sessionEnd();
			return result;
		} catch (DbException e) {
			throw new DbException(e + " ::#:: Problem in DB operation @Customers Insert");
		}
	}

	@Override
	public int update(ProductVO productVO) throws DbException {
		try {
			int success = -1;
			Session dbSession = DbSession.sessionStart();

			Query query = dbSession.createQuery(UPDATE_BY_ID);

			query.setParameter("productNameVal", productVO.getProductName());
			query.setParameter("productLineVal", productVO.getProductLine());
			query.setParameter("productScaleVal", productVO.getProductScale());
			query.setParameter("productVendorVal", productVO.getProductVendor());
			query.setParameter("productDescriptionVal", productVO.getProductDescription());
			query.setParameter("quantityInStockVal", productVO.getQuantityInStock());
			query.setParameter("buyPriceVal", productVO.getBuyPrice());
			query.setParameter("MSRPVal", productVO.getMSRP());
			query.setParameter("productCodeVal", productVO.getProductCode());
			success = query.executeUpdate();
			DbSession.sessionEnd();
			return success;
		} catch (Exception e) {
			throw new DbException(e + " ::#:: Problem in DB operation Update");
		}
	}

	@Override
	public int delete(ProductVO productVO) throws DbException {
		try {
			int success = -1;
			Session dbSession = DbSession.sessionStart();

			Query query = dbSession.createQuery(DELETE_BY_ID);
			query.setParameter("productCodeVal", productVO.getProductCode());
			success = query.executeUpdate();

			DbSession.sessionEnd();
			return success;
		} catch (Exception e) {
			throw new DbException(e + "::#:: Problem in DB operation delete");
		}
	}

}
