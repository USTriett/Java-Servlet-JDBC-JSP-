package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.db.JDBCConnector;
import com.model.Student;

public class StudentList {
    private ArrayList<Student> list;

    public StudentList() {
        this.list = new ArrayList<>();
        this.fetchData();
        
    }
    
    public StudentList(String name) {
        this.list = new ArrayList<>();
        this.fetchData();
        ArrayList<Student> sl = this.findbyName(name);
        list.clear();
        list.addAll(sl);
        for(Student s:list)
        {
        	s.print();
        }
        sl.clear();
    }
    
    public int getSize() {
		return list.size();
	}
    public Student getStudent(int index) {
		return list.get(index);
	}
    
    
    public Student findStudentbyId(int id)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select * From studentmanagement1.student Where id = " + String.valueOf(id);
				
				ResultSet resultSet = stmt.executeQuery(excuteString);
				
				while(resultSet.next())
				{
					Student student = new Student(resultSet.getInt(1), resultSet.getNString(2),
							resultSet.getInt(3), resultSet.getDate(4), resultSet.getNString(5), resultSet.getNString(6));
					System.out.println("Fletch success!");
					con.close();
					return student;
					
				}
				System.out.println("Fletch success!");
				con.close();  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Fetch Failed");
			}
    		
    	}
    	return null;
    }
    public void sortStudentListByGrade() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getGrade() - s2.getGrade();
            }
        });
    }
    
    public void sortStudentListByName() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }
    
    public void fetchData()
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "select * From studentmanagement1.student";
				
				ResultSet resultSet = stmt.executeQuery(excuteString);
				if(!list.isEmpty()) {
					list.clear();
				}
				while(resultSet.next())
				{
					
					Student student = new Student(resultSet.getInt(1), resultSet.getNString(2),
							resultSet.getInt(3), resultSet.getDate(4), resultSet.getNString(5), resultSet.getNString(6));
					list.add(student);
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
    
    public boolean addStudent(Student s)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				String excuteString = "INSERT INTO studentManagement1.student (id, sName, grade, birthday, address, notes)\r\n"
						+ "VALUES\r\n"
						+ "(?, ?, ?, ?, ?, ?)" ;
				PreparedStatement preparableStatement = con.prepareStatement(excuteString);
				preparableStatement.setInt(1, s.getStudentId());
				preparableStatement.setString(2, s.getName());
				preparableStatement.setInt(3, s.getGrade());
				preparableStatement.setDate(4, s.getBirthday());
				preparableStatement.setString(5, s.getAddress());
				preparableStatement.setString(6, s.getNotes());
				preparableStatement.executeUpdate();
				System.out.println(excuteString);

				
				list.add(s);
				
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
    
    public void removeStudent(int id)
    {
    	Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
				Statement stmt = con.createStatement();
				String excuteString = "DELETE FROM studentManagement1.student " +
			            "WHERE id = " + String.valueOf(id);
				String excuteString2 = "DELETE FROM studentManagement1.joinclass " +
			            "WHERE studentid = " + String.valueOf(id);
				
				System.out.println(excuteString);
				stmt.executeUpdate(excuteString2);
				stmt.executeUpdate(excuteString);
				for(Student student:list)
				{
					if(student.getStudentId() == id)
					{
						list.remove(student);
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
    
    public void print() {
		for(Student student:list)
		{
			student.print();
			System.out.println();
		}
	}
    
    public ArrayList<Student> findbyName(String name)
    {
    	ArrayList<Student> l = new ArrayList<>();
    	for(Student s: list)
    	{
    		String temp = s.getName().toLowerCase();
    		if(temp.contains(name.toLowerCase())) {
 
    			l.add(s);
    		}
    	}
    	return l;
    }
    
    public static String getStudentName(int sid) {
		// TODO Auto-generated method stub
		Connection con = JDBCConnector.getJDBCConnection();
		String name = null;



		if(con != null)
		{
			try {
				String excuteString = "select s.sname from studentmanagement1.student s\r\n"
						+ "where s.id = ?";
		
				PreparedStatement statement = con.prepareStatement(excuteString);
				statement.setInt(1, sid);
				
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

	public void edit(int id, String name, int grade, Date birthday, String address, String notes) {
		// TODO Auto-generated method stub
		Connection con = JDBCConnector.getJDBCConnection();
    	if(con != null)
    	{
    		try {
    			
    			String excuteString = "UPDATE studentManagement1.student\r\n"
    					+ "SET  sName = ?, grade = ?, birthday= ?, address = ?, notes= ?\r\n"
    					+ "WHERE id = ?;" ;
				PreparedStatement preparableStatement = con.prepareStatement(excuteString);
				preparableStatement.setInt(6, id);
				preparableStatement.setString(1, name);
				preparableStatement.setInt(2, grade);
				preparableStatement.setDate(3, birthday);
				preparableStatement.setString(4, address);
				preparableStatement.setString(5, notes);
				preparableStatement.executeUpdate();
				
				for(Student student:list)
				{
					if(student.getStudentId() == id)
					{
						student.setName(name);
						student.setGrade(grade);
						student.setBirthday(birthday);
						student.setAddress(address);
						student.setNotes(notes);
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
    
	public Boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	public ArrayList<Integer> getAllId()
	{
		ArrayList<Integer> idlist = new ArrayList<>();
		for(Student s:list)
		{
			idlist.add(s.getStudentId());
		}
		return idlist;
	}
	
}
