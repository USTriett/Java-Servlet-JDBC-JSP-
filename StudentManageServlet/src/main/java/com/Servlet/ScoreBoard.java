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
import com.dao.ScoreStat;

/**
 * Servlet implementation class ScoreBoard
 */
@WebServlet("/ScoreBoard")
public class ScoreBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ScoreStat s = new ScoreStat(0);
		request.setAttribute("studentlist", s);
		CourseList list = new CourseList();
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		int selectedYear = 0;
		request.setAttribute("selectedYear", selectedYear);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/ScoreBoard.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int selectedYear = Integer.valueOf(request.getParameter("year"));
		ScoreStat s = new ScoreStat(selectedYear);
		request.setAttribute("studentlist", s);
		CourseList list = new CourseList();
		ArrayList<Integer> yearlist = list.getAllYear();
		request.setAttribute("yearlist", yearlist);
		request.setAttribute("selectedYear", selectedYear);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./WebContent/ScoreBoard.jsp");
		requestDispatcher.forward(request, response);
	}

}
