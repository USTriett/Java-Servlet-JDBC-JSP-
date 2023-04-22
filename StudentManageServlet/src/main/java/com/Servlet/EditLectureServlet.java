package com.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LectureList;
import com.model.Lecture;

/**
 * Servlet implementation class EditLectureServlet
 */
@WebServlet("/editlecture")
public class EditLectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLectureServlet() {
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
		String name = request.getParameter("name");
		String notes = request.getParameter("notes");
		
		Lecture l = new Lecture(id, year, name, notes);
		request.setAttribute("l", l);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/EditLecture.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int cid = Integer.valueOf(request.getParameter("cid"));
		int year = Integer.valueOf(request.getParameter("cyear"));
		String newName = request.getParameter("name");
		String oldName = request.getParameter("oname");
		String notes = request.getParameter("notes");
		
		LectureList list = new LectureList(cid, year);
		for(int i = 0; i < list.getSize(); i++)
		{
			
			if(list.getLecture(i).getLname().compareTo(oldName) == 0)
			{
				
				list.update(i, newName, notes);
				break;
			}
		}
		String CourseName = String.valueOf(cid) + " in " + String.valueOf(year);
		request.setAttribute("cname", CourseName);

		request.setAttribute("list", list);
		request.setAttribute("year", request.getParameter("year"));
		request.setAttribute("id", request.getParameter("id"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/LectureInCourse.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
