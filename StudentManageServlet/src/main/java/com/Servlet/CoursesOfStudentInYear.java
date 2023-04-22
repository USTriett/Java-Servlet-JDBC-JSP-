package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseList;

/**
 * Servlet implementation class CoursesOfStudentInYear
 */
@WebServlet("/showcourseinyear")
public class CoursesOfStudentInYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesOfStudentInYear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int id = Integer.valueOf(request.getParameter("id"));
		CourseList list = new CourseList(id);
		ArrayList<Integer> yearlist = list.getAllYear();
		String name = "Courses of Student, id = " + String.valueOf(id);
		request.setAttribute("list", list);
		request.setAttribute("yearlist", yearlist);
		request.setAttribute("name", name);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/StudentCourses.jsp");
		requestDispatcher.forward(request, response);
	}

}
