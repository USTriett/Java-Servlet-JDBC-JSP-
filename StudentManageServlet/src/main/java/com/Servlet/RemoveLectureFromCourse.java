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
 * Servlet implementation class RemoveLectureFromCourse
 */
@WebServlet("/lectureremove")
public class RemoveLectureFromCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLectureFromCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		int year = Integer.valueOf(request.getParameter("year"));
		String name = request.getParameter("name");
		
		LectureList list = new LectureList(id, year);
		list.remove(name);
		String CourseName = String.valueOf(id) + " in " + String.valueOf(year); 

		request.setAttribute("list", list);
		request.setAttribute("cname", CourseName);
		request.setAttribute("year", request.getParameter("year"));
		request.setAttribute("id", request.getParameter("id"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/LectureInCourse.jsp");
		requestDispatcher.forward(request, response);
	}

}
