package com.model;

public class StudentModel {

	private int rollNo;
	private String name;
	private String address;
	private int marks;
	private int age;
	private int gender;
	
	public StudentModel(int rollNo, String name, String address, int marks, int age, int gender) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.marks = marks;
		this.age = age;
		this.gender = gender;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
