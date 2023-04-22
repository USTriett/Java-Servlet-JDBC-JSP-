package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.JDBCConnector;

public class StudentScore {
	private int id;
	private int year;
	private float score;
	
	public StudentScore(int id, int year) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.year = year;
		try {
			Connection con = JDBCConnector.getJDBCConnection();
			if(con != null)
			{
				if(year == 0) // GPA all
				{
					String sql = "select avg(j.score)\r\n"
							+ "From studentmanagement1.joinclass j\r\n"
							+ "where j.studentid = ?\r\n"
							+ "group by j.studentid";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setInt(1, id);
					System.out.println(statement.toString());
					ResultSet set = statement.executeQuery();
					if(set.next())
					{
						this.score = set.getFloat(1);
					}
					else {
						this.score = 0;
					}
				}
				else {
					String sql = "select avg(j.score)\r\n"
							+ "From studentmanagement1.joinclass j\r\n"
							+ "where j.studentid = ? and j.classyear = ?\r\n"
							+ "group by j.studentid";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setInt(1, id);
					statement.setInt(2, year);
					ResultSet set = statement.executeQuery();
					if(set.next())
					{
						this.score = set.getFloat(1);
					}
					else {
						this.score = 0;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public float getScore(){
		return this.score;
	}
	public int getId() {
		return this.id;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getStudentName()
	{
		return StudentList.getStudentName(id);
	}
}
