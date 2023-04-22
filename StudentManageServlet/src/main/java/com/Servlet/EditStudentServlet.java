package com.Servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Help.Helper;
import com.dao.StudentList;
import com.model.Student;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int id = Integer.valueOf( request.getParameter("id"));
		StudentList list = new StudentList();
		Student std = list.findStudentbyId(id);
		request.setAttribute("std", std);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/EditStudent.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	    request.setCharacterEncoding("UTF-8");
	    try {
	    	StudentList list = new StudentList();
			int id = Integer.valueOf( request.getParameter("id"));
			String name = request.getParameter("name");
			
			
			int grade = Integer.valueOf(request.getParameter("grade"));
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			String address = Helper.getUTF8String(request.getParameter("address")) ;
			String notes = request.getParameter("notes");
			list.edit(id, name, grade, birthday, address, notes);
			
			response.sendRedirect("./ListStudent");
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
		
	}

}
