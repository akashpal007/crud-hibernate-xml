package com.j2ee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2ee.dao.ProductsDao;
import com.j2ee.dao.impl.ProductsDaoImpl;
import com.j2ee.vo.ProductVO;

import base.DbException;

@WebServlet("/productsEdit")
public class ProductsEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1944408421915908353L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductVO product = new ProductVO();
		product.setProductCode(req.getParameter("productCode"));
		product.setProductName(req.getParameter("productName"));
		product.setProductLine(req.getParameter("productLine"));
		product.setProductScale(req.getParameter("productScale"));
		product.setProductVendor(req.getParameter("productVendor"));
		product.setProductDescription(req.getParameter("productDescription"));
		product.setQuantityInStock(Integer.parseInt(req.getParameter("quantityInStock")));
		product.setBuyPrice(Double.parseDouble(req.getParameter("buyPrice")));
		product.setMSRP(Double.parseDouble(req.getParameter("mSRP")));

		ProductsDao dao = new ProductsDaoImpl();
		try {
			dao.update(product);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("products").forward(req, resp);
	}
}
