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

@WebServlet("/productlinesDelete")
public class ProductlinesDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5026817121052877110L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductLineVO productLineVO = new ProductLineVO();
		productLineVO.setProductLine(req.getParameter("productLine"));

		ProductlinesDao dao = new ProductlinesDaoImpl();
		try {
			dao.delete(productLineVO);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("productlines").forward(req, resp);
	}

}
