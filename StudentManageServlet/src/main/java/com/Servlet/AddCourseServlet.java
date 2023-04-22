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
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/addcourse")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/AddCourse.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		CourseList list = new CourseList();
		int id = list.getSize() + 1;
		String name = request.getParameter("name");
		ArrayList<Course> fCourses =  list.findbyName(name);
		int year = Integer.valueOf(request.getParameter("year"));
		if(!fCourses.isEmpty())
		{
			id = fCourses.get(0).getId();
			for(Course c:fCourses)
			{
				if(c.getYear()==year)
				{
					id = list.getSize() + fCourses.size() + 1;
					break;
				}
			}
			
		}
		else {
			for(int i = 0 ; i < list.getSize()-1; i++)
			{
				if(list.getCourse(i).getId() == id && list.getCourse(i).getYear() == year)
				{
					id++;
				}
			}
		}
	
		
		
		String notes = request.getParameter("notes");
		
		Course c = new Course(id, year, name, notes);
		if(list.addCourse(c))
		{
			
			response.sendRedirect("./showlecture?id=" + String.valueOf(id) + "&year=" +String.valueOf(year));
			
		}
	}

}
