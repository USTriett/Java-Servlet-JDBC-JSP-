package com.model;

public class Course {
	private int _id;
	private int _year;
	private String _name;
	private String _notes;
	
	 public Course(int Id, int year, String name, String notes) {
	        this._id = Id;
	        this._name = name;
	        this._year = year;
	        this._notes = notes;
	 }

	    public int getId() {
	        return _id;
	    }

	    public void setId(int Id) {
	        this._id = Id;
	    }

	    public String getName() {
	        return _name;
	    }

	    public void setName(String name) {
	        this._name = name;
	    }

	    
	    public int getYear() {
			return _year;
		}
	    
	    public void setYear(int year)
	    {
	    	this._year = year;
	    }
	    
	    public String getNotes() {
	        return _notes;
	    }

	    public void setNotes(String notes) {
	        this._notes = notes;
	    }
	    
	    public String toString() {
			return String.valueOf(_id) + "/" + this._name + "/" + String.valueOf(_year) + "/" + this._notes;
		}
	    
	    public void print()
	    {
	    	System.out.println(this.toString());
	    }
	
}
