package com.tasks.courseregistration;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
	
	List<Student> studentsList = new ArrayList<>();
	
	public Student authenticate(String id, String pwd) throws Exception {
		
		String query = "select count(student_id) from public.student where student_roll = '%s' and student_pwd = '%s' ;";
		
		ResultSet result = DbConnections.ExecuteQuery(String.format(query, id,pwd));
		result.next();
		if(result.getInt(1)==1) {
			query = "select * from public.student where student_roll = '%s' and student_pwd = '%s' ;";
			result = DbConnections.ExecuteQuery(String.format(query, id,pwd));
			result.next();
			Student s = new Student(result.getString(1),result.getString(2), result.getString(3), result.getString(4));
			return s;
		}
		
		
		return null;
	}
	
	
	
	public boolean logout(String id) {
		return true;
	}



	public List<Map<String, String>> getRegisteredCourses(Student student) throws ClassNotFoundException, SQLException {
		String query = "select c.course_code ,c.course_title ,c.description ,c.schedule  from public.student st \r\n"
				+ "left join student_courses sc on st.student_id  = sc.studentid \r\n"
				+ "left join course c on sc.courseid = c.course_id \r\n"
				+ "where student_id = %s;";
		
		ResultSet rs = DbConnections.ExecuteQuery(String.format(query, student.getStudent_id()));
		
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



	public List<Map<String, String>> getUnRegisteredCourses(Student student) throws SQLException, ClassNotFoundException {
		String query = "select * from course c where c.course_id not in (select sc.courseid  from student_courses sc where sc.studentid= %s);";
		ResultSet result = DbConnections.ExecuteQuery(String.format(query, student.getStudent_id()));
		
		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
		ResultSetMetaData md = result.getMetaData();
		int columns = md.getColumnCount();

        while (result.next()) {
            Map<String, String> row = new HashMap<String, String>();
            for (int i = 1; i <= columns; i++) {
                row.put(md.getColumnLabel(i).toUpperCase(), result.getString(i));
            }
            results.add(row);
        }
		
		
		return results;
	}
	
	
}
