package com.tasks.courseregistration;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistrationService {
	
	public int getCourseId(String course_code) throws ClassNotFoundException, SQLException {
		String query = "select course_id from course where course_code =  '%s';";
		ResultSet rs = DbConnections.ExecuteQuery(String.format(query, course_code));
		rs.next();
		
		return rs.getInt(1);
	}

	public List<Map<String, String>> getAvailableCourses(Student student) throws ClassNotFoundException, SQLException {
		String query = "select * from course";
		
		ResultSet rs = DbConnections.ExecuteQuery(String.format(query));
		
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		
		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
        
        while (rs.next()) {
            Map<String, String> row = new HashMap<String, String>();
            for (int i = 1; i <= columns; i++) {
                row.put(md.getColumnLabel(i).toUpperCase(), rs.getString(i));
            }
            results.add(row);
        }
		return results;
		
	}

	public void dropCourses(Student student, String course_code_to_drop) throws ClassNotFoundException, SQLException {
		
		int courseId = getCourseId(course_code_to_drop);
		
		String query = "delete from student_courses where courseid = %s and studentid = %s;";
		DbConnections.ExecuteQuery(String.format(query,courseId, student.getStudent_id()));
		
		
		 query = "update course set capacity  = (capacity +1) where course_id  = %s";
		 DbConnections.ExecuteQuery(String.format(query, courseId));
	}

	public void enrollCourses(Student student, String course_code_to_enroll) throws ClassNotFoundException, SQLException {
		int courseId = getCourseId(course_code_to_enroll);
		
		String query = "select capacity from course where course_id = %s;";
		ResultSet res = DbConnections.ExecuteQuery(String.format(query, courseId));
		res.next();
		if(res.getInt(1)==0) {
			System.out.println("Sorry! The capacity of the class for the selected course is full");
			return;
		}
		
		
	 query = "INSERT INTO student_courses (reg_id,studentid,courseid) VALUES ((select (max(reg_id)+1) from student_courses) ,%s,%s);";
	 DbConnections.ExecuteQuery(String.format(query, student.getStudent_id(),courseId));
	
	
	 query = "update course set capacity  = (capacity -1) where course_id  = %s";
	 DbConnections.ExecuteQuery(String.format(query, courseId));
		
	}

}
