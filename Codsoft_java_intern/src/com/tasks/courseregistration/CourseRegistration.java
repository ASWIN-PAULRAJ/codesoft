package com.tasks.courseregistration;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Credentials {

	String roll, pwd;

}

public class CourseRegistration {

	static Scanner sc;

	public void login(Credentials cred) {
		sc = new Scanner(System.in);
		System.out.print("Enter the following details \r\n");
		System.out.print("Student Roll:");
		cred.roll = (sc.nextLine());
		System.out.print("Student Password:");
		cred.pwd = (sc.nextLine());
	}
	
	public void printEnrolledCourses(List<Map<String, String>> enrolledCourses) {
		if (enrolledCourses.size() == 0) {
			System.out.println("No courses registered");
		} 
		else {
			System.out.println("You have registered for the following courses :");
			for (Map<String, String> course : enrolledCourses) {
				System.out.println("Course code: " + course.get("COURSE_CODE") + "\r\n" + "Course Title: "
						+ course.get("COURSE_TITLE") + "\r\n" + "description  : " + course.get("DESCRIPTION")
						+ "\r\n" + "Scheduled from : " + course.get("SCHEDULE") + "\r\n"
						+ "--------------------------------------------------------------------");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		CourseRegistration reg = new CourseRegistration();
		StudentService sservice = new StudentService();
		CourseRegistrationService regService = new CourseRegistrationService();
		Credentials cred = new Credentials();
		List<Map<String, String>> enrolledCourses = null;
		List<Map<String, String>> unRegisteredCourses = null;
		List<Map<String, String>> availableCourses = null;
		String course_code_to_enroll;
		String course_code_to_drop;
		
		reg.login(cred);

		DbConnections.getConnection();

		Student student = sservice.authenticate(cred.roll, cred.pwd);

		if (student == null) {
			System.out.println("No details found");
		} 
		else {
			enrolledCourses = sservice.getRegisteredCourses(student);
			reg.printEnrolledCourses(enrolledCourses);
			String input;

			while (true) {
				System.out.println("Press 1 to see available courses\r\n"
						+ "Press 2 to see registered courses\r\n"
						+ "Press 3 to Drop from a registered course \r\n" 
						+ "Press 4 registered a course \r\n"
						+ "Press 0 to logout");
				input = sc.nextLine();

				switch (input) {
					case "1":{
						availableCourses = regService.getAvailableCourses(student);
						
						if (availableCourses.size() == 0) {
							System.out.println("No courses to get registered");
						} 
						else {
							System.out.println("here is the list of courses ");
							for (Map<String, String> course : availableCourses) {
								System.out.println("Course code: " + course.get("COURSE_CODE") + "\r\n" + "Course Title: "
										+ course.get("COURSE_TITLE") + "\r\n" + "description  : " + course.get("DESCRIPTION")
										+ "CAPACITY_AVAILABLE" + course.get("CAPACITY")+ "\r\n" 
										+ "\r\n" + "Scheduled from : " + course.get("SCHEDULE") + "\r\n"
										+ "--------------------------------------------------------------------");
							}
						}
					}
					break;
					
					case "2":{
						enrolledCourses = sservice.getRegisteredCourses(student);
						reg.printEnrolledCourses(enrolledCourses);
					}
					break;
					
					case "3":{
						if(enrolledCourses.size()==0) {
							System.out.println("No courses enrolled ");
						}
						else {
							System.out.println("Provide the course code that you want to drop from");
							reg.printEnrolledCourses(enrolledCourses);
							course_code_to_drop = sc.nextLine();
							String cd=course_code_to_drop;
							if(enrolledCourses.stream().filter(course -> course.containsValue(cd)).count()==0) {
								System.out.println("Please select a enrolled course code");
							}
							else {
								regService.dropCourses(student,course_code_to_drop);
							}
						}
					}
					
					break;
					case "4":{
						unRegisteredCourses = sservice.getUnRegisteredCourses(student);
						if (unRegisteredCourses.size() == 0) {
							System.out.println("No courses to get registered");
						} 
						else {
							System.out.println("Select a course code from the below to register ");
							for (Map<String, String> course : unRegisteredCourses) {
								System.out.println("Course code: " + course.get("COURSE_CODE") + "\r\n" + "Course Title: "
										+ course.get("COURSE_TITLE") + "\r\n" + "description  : " + course.get("DESCRIPTION")
										+ "\r\n" + "Scheduled from : " + course.get("SCHEDULE") + "\r\n"
										+ "--------------------------------------------------------------------");
							}
							course_code_to_enroll = sc.nextLine();
							
							String cd=course_code_to_enroll;
							if(unRegisteredCourses.stream().filter(course -> course.containsValue(cd)).count()==0) {
								System.out.println("Please select a valid course code");
							}
							else {
								
								regService.enrollCourses(student,course_code_to_enroll);
							}
						}
					}
					break;
					
					case "0":
					{
						DbConnections.closeConnection();
						System.out.println("Thanks You!");
						System.exit(0);
					}
					break;
					
					default: {
						System.out.println("Select one of the available options");
					}
				}
			}

		}
		//DbConnections.closeConnection();
	}

}
