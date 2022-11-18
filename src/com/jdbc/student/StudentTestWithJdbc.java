package com.jdbc.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestWithJdbc {
	static Connection con;
	static Statement st;

	public static void main(String[] args) throws Exception {
		char ch = 'a';
		con = Connections.getConnection();
		st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> al = new ArrayList();
		do {
			System.out.println("Enter Roll := ");
			int roll = sc.nextInt();
			if (isRollExists(roll)) {

				al.add(createStudent(roll));

			} else
				System.out.println("Roll Number Not Present => " + roll);
			System.out.println("If you want to Continue y/n");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

		System.out.println("ArrayList of Students => " + al);

	}

	public static boolean isRollExists(int roll) throws Exception {

		String q = "select roll from student ";
		ResultSet re = st.executeQuery(q);
		ArrayList<Integer> al = new ArrayList<>();
		while (re.next())
			al.add(re.getInt(1));

		if (al.contains(roll))
			return true;
		else
			return false;

	}

	public static Student createStudent(int roll) throws Exception {
		String q = "select * from student where roll = ?";
		PreparedStatement pt = con.prepareStatement(q);
		pt.setInt(1, roll);
		ResultSet re = pt.executeQuery();
		Student s1 = new Student();
		while (re.next()) {
			s1.setRoll(re.getInt(1));
			s1.setName(re.getString(2));
			s1.setAdd(re.getString(3));
		}
		return s1;

	}

}
