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
import com.dao.StudentsInCourse;
import com.model.StudentJoin;

/**
 * Servlet implementation class ShowScoreOfStudentServlet
 */
@WebServlet("/scoreofstudent")
public class ShowScoreOfStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowScoreOfStudentServlet() {
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
		int sid = Integer.valueOf(request.getParameter("id"));
		CourseList list = new CourseList(sid);
		ArrayList<StudentJoin> slist = new ArrayList<>();
		for(int i = 0; i < list.getSize(); i++)
		{
			StudentJoin s = StudentsInCourse.getStudentInCourse(sid, list.getCourse(i).getId(), list.getCourse(i).getYear());
			slist.add(s);
		}
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		request.setAttribute("list", slist);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/ScoreOfStudent.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
