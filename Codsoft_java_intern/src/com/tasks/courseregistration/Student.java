package com.tasks.courseregistration;

public class Student {

	private static String table_name = "student";
	
	private String studentRoll, studentName,password;

	private String student_id;
	
	public static String getTable_name() {
		return table_name;
	}

	public String getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(String studentID) {
		this.studentRoll = studentID;
	}

//	public Student(String studentRoll, String studentName, String password) {
//		
//		this.studentRoll = studentRoll;
//		this.studentName = studentName;
//		this.password = password;
//	}

	public Student(String student_id,String studentRoll, String studentName,String password) {
		this.student_id = student_id;
		this.studentRoll = studentRoll;
		this.studentName = studentName;
		this.password = password;
	}
	
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
