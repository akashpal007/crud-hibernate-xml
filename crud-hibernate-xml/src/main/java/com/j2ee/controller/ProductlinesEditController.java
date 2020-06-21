package com.j2ee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2ee.dao.ProductlinesDao;
import com.j2ee.dao.impl.ProductlinesDaoImpl;
import com.j2ee.vo.ProductLineVO;

import base.DbException;

@WebServlet("/productlinesEdit")
public class ProductlinesEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4234764393132182140L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductLineVO productLine = new ProductLineVO();
		productLine.setProductLine(req.getParameter("productLine"));
		productLine.setTextDescription(req.getParameter("textDescription"));
		ProductlinesDao dao = new ProductlinesDaoImpl();
		try {
			dao.update(productLine);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("productlines").forward(req, resp);
	}
}
