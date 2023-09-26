package com.tasks.courseregistration;

public class Course {
	
	static String table_name = "course";
	
	private String courseCode,courseTitle,description,schedule;
	private int capacity;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Course(String courseCode, String courseTitle, String description, int capacity, String schedule) {
		
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
	}
	
	
}
