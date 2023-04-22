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
 * Servlet implementation class ListCourses
 */
@WebServlet({"/courses", "/courseremove"})
public class ListCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		CourseList list = new CourseList();
		request.setAttribute("list", list);
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/ListCourses.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int sID = Integer.valueOf( request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		
		CourseList list = new CourseList();
		list.remove(sID, year);
		response.sendRedirect("./courses");
	}

}
