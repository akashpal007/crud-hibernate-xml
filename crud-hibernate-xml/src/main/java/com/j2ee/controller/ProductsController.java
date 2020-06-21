package com.j2ee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j2ee.dao.ProductsDao;
import com.j2ee.dao.impl.ProductsDaoImpl;
import com.j2ee.vo.ProductVO;

import base.DbException;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622426130755402350L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductsDao dao = new ProductsDaoImpl();
		List<ProductVO> products;
		try {
			products = dao.selectAll();
			HttpSession session = req.getSession();
			session.setAttribute("products", products);
			resp.sendRedirect("products.jsp");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
