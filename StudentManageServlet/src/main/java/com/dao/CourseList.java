package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.db.JDBCConnector;
import com.model.Course;
import com.model.Student;

public class CourseList {
	private ArrayList<Course> list;

    public CourseList() {
        this.list = new ArrayList<>();
        this.fetchData();
        
    }
    
    
    
    public CourseList(int studentID)
    {
    	this.list = new ArrayList<>();
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
    			String sql = "select *\r\n"
    					+ "from studentmanagement1.Course c, studentmanagement1.joinclass j\r\n"
    					+ "where j.studentid = ? and c.id = j.classid and c.cyear = j.classyear";
				PreparedStatement statement = con.prepareStatement(sql);
				
				statement.setInt(1, studentID);
	
				ResultSet resultSet = statement.executeQuery();

				while(resultSet.next())
				{
					
					Course course = new Course(resultSet.getInt(1), resultSet.getInt(2),
							resultSet.getNString(3), resultSet.getNString(4));
					list.add(course);
				}
				System.out.println("Fletch success!");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    }
    
    

    
    public CourseList(String name) {
		// TODO Auto-generated constructor stub
    	 this.list = new ArrayList<>();
         this.fetchData();
         ArrayList<Course> sl = this.findCourseByName(name);
         list.clear();
         list.addAll(sl);
         for(Course s:list)
         {
         	s.print();
         }
         sl.clear();
	}

    
	public int getSize() {
		return list.size();
	}
    public Course getCourse(int index) {
		return list.get(index);
	}
    
    public Course findCourse(int id, int year) {
		for(Course c:list)
		{
			if(c.getId() == id && c.getYear() == year)
				return c;
		}
		return null;
	}
    
    public void updateCourse(int id ,int year, String name, String notes)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
    			String sql = "UPDATE studentManagement1.course\r\n"
    					+ "SET  cname = ?, notes = ?\r\n"
    					+ "WHERE id = ? and cyear = ?";
				PreparedStatement statement = con.prepareStatement(sql);
				
				statement.setNString(1, name);
				statement.setNString(2, notes);
				statement.setInt(3, id);
				statement.setInt(4, year);
				statement.executeUpdate();
				for(Course c:list)
				{
					if(c.getId() == id && c.getYear() == year)
					{
						c.setName(name);
						c.setNotes(notes);
						break;
					}
				}

				System.out.println("Fletch success!");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    }
    
    public ArrayList<Integer> getAllYear() {
    	ArrayList<Integer> yearList = new ArrayList<>(); 
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select distinct c.cyear From studentmanagement1.course c";
				
				ResultSet resultSet = stmt.executeQuery(excuteString);
			
				while(resultSet.next())
				{
					
					yearList.add(resultSet.getInt(1));
				}
				System.out.println("Fletch success!");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return yearList;
	}
    
    
    public static ArrayList<Integer> getStudentCourse(int sid)
    {
  
    	Connection con = JDBCConnector.getJDBCConnection();
    	ArrayList<Integer> classlist = new ArrayList<>();
    	if(con != null)
    	{
    		try {
				String excuteString = "Select j.classid\r\n"
						+ "From studentmanagement1.joinclass j where j.studentid = ?";
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, sid);
				ResultSet resultSet = statement.executeQuery();
			
				while(resultSet.next())
				{
					int id = resultSet.getInt(1);
					classlist.add(id);
				}
				System.out.println("Fletch success!");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return classlist;
    	
    }
    
    public static CourseList getCourseInYear(int year)
    {
    	CourseList cl = new CourseList();
    	ArrayList<Course> l = new ArrayList<>();
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select * From studentmanagement1.course c Where c.cyear=" + String.valueOf(year);
				
				ResultSet resultSet = stmt.executeQuery(excuteString);
			
				while(resultSet.next())
				{
					
					Course course = new Course(resultSet.getInt(1), resultSet.getInt(2),
							resultSet.getNString(3), resultSet.getNString(4));
					l.add(course);
				}
				System.out.println("Fletch success!");
				con.close();
				cl.list.clear();
				cl.list.addAll(l);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return cl;
    	
    }
    
    public ArrayList<Course> findCourseByName(String name)
    {
    	ArrayList<Course> l = new ArrayList<>();
    	for(Course s:list)
    	{
    		String temp = s.getName().toLowerCase();
    		if(temp.contains(name.toLowerCase()))
    			l.add(s);
    	}
    	System.out.println("Cannot find!");
    	return l;
    }
    
    public void sortCourseListByName() {
        Collections.sort(list, new Comparator<Course>() {
            @Override
            public int compare(Course s1, Course s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }
    
    public boolean isEmpty() {
		return list.isEmpty();
	}
    
    public void fetchData()
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select * From studentmanagement1.course";
				
				ResultSet resultSet = stmt.executeQuery(excuteString);
				if(!list.isEmpty()) {
					list.clear();
				}
				while(resultSet.next())
				{
					
					Course course = new Course(resultSet.getInt(1), resultSet.getInt(2),
							resultSet.getNString(3), resultSet.getNString(4));
					list.add(course);
				}
				System.out.println("Fletch success!");
				con.close();  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
 
    	
    }
    
    public boolean addCourse(Course c)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "INSERT INTO studentManagement1.course (id, cYear, cName, notes)\r\n"
						+ "VALUES\r\n"
						+ "(" + String.valueOf(c.getId()) + ", '" + String.valueOf(c.getYear()) + "' , '" + c.getName() + "', '"
						+ c.getNotes() + "')" ;
				System.out.println(excuteString);
				stmt.executeUpdate(excuteString);
				
				list.add(c);
				
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
    
    public void remove(int id, int year)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
    			String excuteString = "DELETE FROM studentManagement1.joinclass " +
			            "WHERE classid =  ? and classyear = ?";
    			PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, id);
				statement.setInt(2, year);
				statement.executeUpdate();
				
				excuteString = "DELETE FROM studentManagement1.lecture " +
			            "WHERE classid =  ? and classyear = ?";
    			PreparedStatement statement1 = con.prepareStatement(excuteString);
				statement1.setInt(1, id);
				statement1.setInt(2, year);
				statement1.executeUpdate();
    			
				excuteString = "DELETE FROM studentManagement1.course " +
			            "WHERE id =  ? and cyear = ?";
				
				PreparedStatement statement2 = con.prepareStatement(excuteString);
				statement2.setInt(1, id);
				statement2.setInt(2, year);
				statement2.executeUpdate();
				for(Course c: list)
				{
					if(c.getId() == id)
					{
						list.remove(c);
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
    
    public void print() {
		for(Course c:list)
		{
			c.print();
			System.out.println();
		}
	}
    
    public ArrayList<Course> findbyName(String name)
    {
    	ArrayList<Course> l = new ArrayList<>();
    	for(Course c: list)
    	{
    		if(c.getName().compareTo(name) == 0) {
    			System.out.println(1);
    			l.add(c);
    		}
    	}
    	return l;
    }
    
    public ArrayList<Student> showStudentInCourse(int courseId, int year)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select s.*\r\n"
						+ "From studentmanagement1.student s, studentmanagement1.joinclass j, studentmanagement1.course c\r\n"
						+ "Where s.id = j.studentid and c.id =" + String.valueOf(courseId) + " and c.id = j.classid and c.cyear= " +String.valueOf(year);
				System.out.println(excuteString);
				ResultSet resultSet = stmt.executeQuery(excuteString);
				ArrayList<Student> l = new ArrayList<>(); 
				while(resultSet.next())
				{
					
					Student student = new Student(resultSet.getInt(1), resultSet.getNString(2),
							resultSet.getInt(3), resultSet.getDate(4), resultSet.getNString(5), resultSet.getNString(6));
					l.add(student);
				}
				
				
				
				System.out.println("Fetch success!");
				con.close();  
				return l;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return null;
    }

	public String getCourseName(int id, int year) {
		// TODO Auto-generated method stub
		Connection con = JDBCConnector.getJDBCConnection();
		if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "Select c.cname\r\n"
						+ "from studentmanagement1.course c\r\n"
						+ "Where c.id=" + String.valueOf(id) + " and c.cyear=" + String.valueOf(year);
				System.out.println(excuteString);
				ResultSet resultSet = stmt.executeQuery(excuteString);
				String name = null;
				while(resultSet.next())
				{
					name = resultSet.getNString(1);
					return name;
				}
				
				
				
				System.out.println("Fetch success!");
				con.close();  
				return name;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return null;
    }



	public static String getClassName(int cid2, int year) {
		// TODO Auto-generated method stub
		Connection con = JDBCConnector.getJDBCConnection();
		String name = null;



		if(con != null)
		{
			try {
				String excuteString = "select c.cname from studentmanagement1.course c\r\n"
						+ "where c.id = ? and c.cyear = ?";
		
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, cid2);
				statement.setInt(2, year);
				
				System.out.println(excuteString);
				ResultSet rs = statement.executeQuery();
				while(rs.next())
				{
					name = rs.getNString(1);
					
				}
				
				System.out.println("Fetch success!");
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}

		}
		return name;
	}
}
