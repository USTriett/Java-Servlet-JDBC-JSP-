package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentsInCourse;

/**
 * Servlet implementation class AddStudentIntoCourse
 */
@WebServlet("/addstudentinto")
public class AddStudentIntoCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentIntoCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int id = Integer.valueOf(request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		request.setAttribute("year", year);
		request.setAttribute("id", id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/AddStudentIntoCourse.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int id = Integer.valueOf(request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		int sid = Integer.valueOf(request.getParameter("sid"));
		float score = Float.valueOf(request.getParameter("score"));
		StudentsInCourse sic = new StudentsInCourse(id, year);
		if(sic.addStudent(sid, id, year, score))
		{
			String CourseName = String.valueOf(id) + " in " + String.valueOf(year); 
			request.setAttribute("list", sic);
			request.setAttribute("cname", CourseName);
			request.setAttribute("year", year);
			request.setAttribute("id", id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/StudentInCourse.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("year", year);
			request.setAttribute("id", id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/AddStudentIntoCourse.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}