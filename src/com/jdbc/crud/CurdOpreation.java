package com.jdbc.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.student.Connections;

public class CurdOpreation {

	static Connection con;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		con = Connections.getConnection();

		System.out.println("Enter 1 for Read Opretion   =>");
		System.out.println("Enter 2 for Delete Opretion =>");
		System.out.println("Enter 3 for Create Opretion =>");
		System.out.println("Enter 4 for Update Opretion =>");
		int choice = sc.nextInt();
		if (choice == 1 || choice == 2 || choice == 3 || choice == 4)
			selectOperation(choice);
		else
			System.out.println("Enter Valid Operation...!!!");

	}

	public static void selectOperation(int choice) throws Exception {

		if (choice == 1) {
			System.out.println("Enter Roll => ");
			int roll = sc.nextInt();
			if (isRollExists(roll))
				System.out.println("Data From Database => " + read(roll));
			else
				System.out.println("Roll Number Not Present => " + roll);
		}
		if (choice == 2) {
			System.out.println("Enter Roll => ");
			int roll = sc.nextInt();
			if (isRollExists(roll))
				System.out.println("Data Deleted From Database => " + delete(roll));
			else
				System.out.println("Roll Number Not Present => " + roll);
		}
		if (choice == 3) {
			System.out.println("Enter Roll , Name , Address => ");
			Student s = new Student();
			int roll = sc.nextInt();
			if (!(isRollExists(roll))) {
				s.setRoll(roll);
				s.setName(sc.next());
				s.setAddress(sc.next());
				System.out.println("Data Added to Database => " + create(s));
			} else
				System.out.println("Roll Number is Already Present =>" + roll + " " + "...Try Another One...!!!");
		}
		if (choice == 4) {
			System.out.println("Enter Old Roll No. and New Roll No. => ");
			int oldroll = sc.nextInt();

			if (isRollExists(oldroll)) {
				int newroll = sc.nextInt();
				System.out.println("Data Updated to Database => " + update(oldroll, newroll));
			} else {
				System.out.println("Roll Number is Not Present =>" + oldroll);
				System.out.println("We Create New Data With This Roll Number => " + create(oldroll));
			}

		}
	}

	public static boolean isRollExists(int roll) throws Exception {

		String query = "select roll from student ";
		PreparedStatement pt = con.prepareStatement(query);
		ResultSet re = pt.executeQuery();
		ArrayList<Integer> al = new ArrayList<>();
		while (re.next())
			al.add(re.getInt(1));
		if (al.contains(roll))
			return true;
		else
			return false;
	}

	public static Student read(int roll) throws Exception {
		String query = "select * from student where roll =? ";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setInt(1, roll);
		ResultSet re = pt.executeQuery();
		Student s1 = new Student();
		while (re.next()) {
			s1.setRoll(re.getInt(1));
			s1.setName(re.getString(2));
			s1.setAddress(re.getString(3));
		}
		return s1;

	}

	public static boolean delete(int roll) throws Exception {
		String query = "delete from student where roll= ?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setInt(1, roll);
		int row = pt.executeUpdate();
		if (row == 1)
			return true;
		else
			return false;
	}

	public static Student create(Student s) throws Exception {
		String query = "insert into student values (? , ? , ?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setInt(1, s.getRoll());
		pt.setString(2, s.getName());
		pt.setString(3, s.getAddress());
		int row = pt.executeUpdate();
		if (row == 1)
			return s;
		else
			return null;
	}

	public static Student create(int oldroll) throws Exception {
		String query = "insert into  student (roll)values (?)";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setInt(1, oldroll);
		int row = pt.executeUpdate();
		if (row == 1)
			return read(oldroll);
		else
			return null;
	}

	public static Student update(int oldroll, int newroll) throws Exception {
		String query = "update student set roll = ? where roll = ?";
		PreparedStatement pt = con.prepareStatement(query);
		pt.setInt(1, newroll);
		pt.setInt(2, oldroll);
		int row = pt.executeUpdate();
		if (row == 1)
			return read(newroll);
		else
			return null;
	}

}
