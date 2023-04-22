package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.JDBCConnector;
import com.model.StudentJoin;

public class StudentsInCourse {
	private ArrayList<StudentJoin> sjList = null;
	private Connection con = null;
	
	public StudentsInCourse()
	{
		con = JDBCConnector.getJDBCConnection();
	}
	
	
	public StudentsInCourse(int cid, int cyear) {
		// TODO Auto-generated constructor stub
		con = JDBCConnector.getJDBCConnection();
		
		
		
		if(con != null)
    	{
    		try {
    			String statement = "Select distinct s.id, s.sName, c.id, c.cName, c.cyear, j.score\r\n"
    					+ "From studentmanagement1.student s, studentmanagement1.joinclass j, studentmanagement1.course c\r\n"
    					+ "Where s.id = j.studentid and c.id= ? and c.id = j.classid and j.classyear = c.cyear and c.cyear= ?";
    			PreparedStatement s = con.prepareStatement(statement);
    			s.setInt(1, cid);
    			s.setInt(2, cyear);
    			ResultSet set = s.executeQuery();
    			
    			sjList = new ArrayList<>();
    			while(set.next())
    			{
    				int sid = set.getInt(1);
    				String sname = set.getNString(2);
    				
    				String cname = set.getNString(4);

    				float score = set.getFloat(6);
    				
    				StudentJoin sj = new StudentJoin(sid, sname, cid, cname, cyear, score);
    				sjList.add(sj);
    				
    			}
    			
    			
    			
				System.out.println("Fetch success!");
				con.close();  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
	}
	
	public static StudentJoin getStudentInCourse(int sid, int cid, int cyear) {
		// TODO Auto-generated constructor stub
		Connection con = JDBCConnector.getJDBCConnection();
		
		
		
		if(con != null)
    	{
    		try {
    			String statement = "Select distinct s.sName, c.cName, j.score\r\n"
    					+ "From studentmanagement1.student s, studentmanagement1.joinclass j, studentmanagement1.course c\r\n"
    					+ "Where s.id = j.studentid and s.id = ? and c.id= ? and c.id = j.classid and c.cyear= ?";
    			PreparedStatement s = con.prepareStatement(statement);
    			s.setInt(1, sid);
    			s.setInt(2,cid);
    			s.setInt(3, cyear);
    			ResultSet set = s.executeQuery();
    			
    			if(set.next())
    			{
    				String name = set.getNString(1);
    				String cname = set.getNString(2);
    				Float score = set.getFloat(3);
    				return new StudentJoin(sid, name, cid, cname, cyear, score);
    			}
    			
    			
    			
				System.out.println("Fetch success!");
				con.close();  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
		return null;
	}
	
	public boolean addStudent(int sid, int cid, int year, float score) {
		con = JDBCConnector.getJDBCConnection();



		if(con != null)
		{
			try {
				String excuteString = "insert into studentmanagement1.joinclass(studentid, classid, classyear, score)\r\n"
						+ "values\r\n"
						+ "(?, ?, ?, ?)";
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, sid);
				statement.setInt(2, cid);
				statement.setInt(3, year);
				statement.setFloat(4, score);
				System.out.println(excuteString);
				statement.executeUpdate();
				
				StudentJoin sJoin = new StudentJoin(sid, cid, year, score);
				sjList.add(sJoin);
				System.out.println("Fetch success!");
				con.close(); 
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}

		}
		return false;
	}
	
	public StudentJoin getStudentJoin(int index) {
		return sjList.get(index);
	}
	
	public boolean isEmpty() {
		if(sjList.isEmpty())
			return true;
		return false;
	}
	
	public int getSize()
	{
		return sjList.size();
	}

	public void setScore(int sid, float score)
	{
		con = JDBCConnector.getJDBCConnection();



		if(con != null)
		{
			try {
				String excuteString = "UPDATE studentManagement1.joinclass\r\n"
    					+ "SET  score = ?\r\n"
    					+ "WHERE studentid = ?;" ;
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setFloat(1, score);
				statement.setInt(2, sid);
				
				System.out.println(statement.toString());
				statement.executeUpdate();
				for(StudentJoin s:sjList)
				{
					if(s.getStudentId() == sid)
					{
						s.setScore(score);
						break;
					}
					
				}
				System.out.println("Fetch success!");
				con.close(); 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
		}
	}
	public boolean removeStudent(int sid, int cid, int year) {
		// TODO Auto-generated method stub
		con = JDBCConnector.getJDBCConnection();



		if(con != null)
		{
			try {
				String excuteString = "delete from studentmanagement1.joinclass\r\n"
						+ "where studentid = ? and classid = ? and classyear = ?";
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, sid);
				statement.setInt(2, cid);
				statement.setInt(3, year);
				System.out.println(excuteString);
				statement.executeUpdate();
				for(StudentJoin s:sjList)
				{
					if(s.getStudentId() == sid)
					{
						sjList.remove(s);
						break;
					}
					
				}
				System.out.println("Fetch success!");
				con.close(); 
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}

		}
		return false;
	}


	
	

}
