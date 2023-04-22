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
 * Servlet implementation class RemoveStudentFromCourse
 */
@WebServlet("/removestudentfrom")
public class RemoveStudentFromCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStudentFromCourse() {
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

		int sid = Integer.valueOf(request.getParameter("sid"));
		int cid = Integer.valueOf(request.getParameter("cid"));
		int year = Integer.valueOf(request.getParameter("cyear"));
		StudentsInCourse sic = new StudentsInCourse(cid, year);
		String CourseName = String.valueOf(cid) + " in " + String.valueOf(year);
		if(sic.removeStudent(sid, cid, year))
		{
			System.out.println("remove success!");
			
		}
		else {
			System.out.println("remove fail");
		}
		request.setAttribute("list", sic);
		request.setAttribute("cname", CourseName);
		request.setAttribute("year", year);
		request.setAttribute("id", cid);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/StudentInCourse.jsp");
		requestDispatcher.forward(request, response);
	}

}
