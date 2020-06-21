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
@WebServlet("/productsDelete")
public class ProductsDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5491690524751095651L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductVO productVO = new ProductVO();
		productVO.setProductCode(req.getParameter("productCode"));

		ProductsDao dao = new ProductsDaoImpl();
		try {
			dao.delete(productVO);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("products").forward(req, resp);
	}
}
