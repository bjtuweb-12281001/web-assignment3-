package com.zmm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zmm.model.UserBeanDeal;

public class RegisteServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("zmm");
		String username=request.getParameter("u_name");
	//	username=Tools.getNewString(username);
		String email = request.getParameter("u_email");
		//String g = request.getParameter("u_grape");
		int grade = 5;
		String passwd = request.getParameter("u_pass");
		System.out.print("zmm");
		UserBeanDeal ubd = new UserBeanDeal();
		if(ubd.addUser(username, passwd, email))
		{
			request.getSession().setAttribute("myName", username);
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("registration.html").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("zmm");
		this.doGet(request, response);
	}

}
