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
import com.model.Course;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/editcourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int id = Integer.valueOf( request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		
		CourseList list = new CourseList();
		Course c = list.findCourse(id, year);
		request.setAttribute("c", c);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/EditCourse.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf( request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		String name = request.getParameter("name");
		String notes = request.getParameter("notes");
		CourseList list = new CourseList();
		list.updateCourse(id, year, name, notes);
		request.setAttribute("list", list);
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/ListCourses.jsp");
		requestDispatcher.forward(request, response);
	}

}
