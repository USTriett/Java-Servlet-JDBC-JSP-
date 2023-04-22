package com.model;

import java.sql.Date;

public class Student {
    private int studentId;
    private String name;
    private int grade;
    private Date birthday;
    private String address;
    private String notes;

    
    public Student() {
    	
    }
    public Student(int studentId, String name, int grade, Date birthday, String address, String notes) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.birthday = birthday;
        this.address = address;
        this.notes = notes;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void print() {
		System.out.println(this.toString());
	}
    public String toString() {
		return String.valueOf(studentId) + "/" + this.name + "/" + String.valueOf(grade) + "/" + this.address + "/" + this.notes;
	}
    
}
