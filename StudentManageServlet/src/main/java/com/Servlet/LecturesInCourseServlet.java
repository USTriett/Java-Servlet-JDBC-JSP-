package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LectureList;

/**
 * Servlet implementation class LecturesInCourse
 */
@WebServlet("/showlecture")
public class LecturesInCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturesInCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int cid = Integer.valueOf(request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		LectureList list = new LectureList(cid, year);
		String CourseName = String.valueOf(cid) + " in " + String.valueOf(year); 
		request.setAttribute("list", list);
		request.setAttribute("cname", CourseName);
		request.setAttribute("year", request.getParameter("year"));
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("list", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/LectureInCourse.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");

			int id = Integer.valueOf(request.getParameter("id"));
			int year = Integer.valueOf(request.getParameter("year"));
			LectureList list = new LectureList(id, year);
			String CourseName = String.valueOf(id) + " in " + String.valueOf(year); 
			request.setAttribute("list", list);
			request.setAttribute("cname", CourseName);
			request.setAttribute("year", request.getParameter("year"));
			request.setAttribute("id", request.getParameter("id"));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/LectureInCourse.jsp");
			requestDispatcher.forward(request, response);
	}

}