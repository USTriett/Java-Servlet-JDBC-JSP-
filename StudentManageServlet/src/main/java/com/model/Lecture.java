package com.model;

public class Lecture {
	private int cid;
	private int cyear;
	private String lname;
	private String notes;
	
	public Lecture(int cid,int cyear, String lname, String notes)
	{
		this.cid = cid;
		this.cyear = cyear;
		this.lname = lname;
		this.notes = notes;
	}
	
	public int getClassId() {
		return cid;
	}
	public void setClassId(int cid) {
		this.cid = cid;
	}
	public int getClassYear() {
		return cyear;
	}
	public void setClassYear(int cyear) {
		this.cyear = cyear;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
