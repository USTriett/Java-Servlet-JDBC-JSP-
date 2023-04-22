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
 * Servlet implementation class SearchCourse
 */
@WebServlet("/searchcourse")
public class SearchCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		System.out.println(name);
		CourseList list = new CourseList(name);
		request.setAttribute("list", list);
		String title = "Search for '" + name + "'";
		request.setAttribute("title", title);
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/FindCourse.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
