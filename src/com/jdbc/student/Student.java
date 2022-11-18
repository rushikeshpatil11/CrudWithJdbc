package com.jdbc.student;

public class Student {
	
	int roll;
	String name;
	String address;
	public Student() {
		super();
	}
	public Student(int roll, String name, String address) {
		super();
		this.roll = roll;
		this.name = name;
		this.address= address;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
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
	public void setAdd(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + "]";
	}
	

}
