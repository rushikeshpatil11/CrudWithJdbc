package com.jdbc.crud;

public class Student {
	int roll;
	String name;
	String address;
	Student(){
		
	}
	Student(int roll,String name,String address){
		this.roll=roll;
		this.name=name;
		this.address=address;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll=roll;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + "]";
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
	
}
