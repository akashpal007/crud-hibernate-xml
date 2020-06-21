package com.j2ee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j2ee.dao.ProductlinesDao;
import com.j2ee.dao.impl.ProductlinesDaoImpl;
import com.j2ee.vo.ProductLineVO;

import base.DbException;

@WebServlet("/productlines")
public class ProductlinesController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5442497147414550160L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductlinesDao dao = new ProductlinesDaoImpl();
		List<ProductLineVO> productLines;
		try {
			productLines = dao.selectAll();
			HttpSession session = req.getSession();
			session.setAttribute("productLines", productLines);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("productlines.jsp");
	}
}
