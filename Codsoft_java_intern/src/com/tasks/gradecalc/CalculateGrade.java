package com.tasks.gradecalc;

import java.util.Scanner;

public class CalculateGrade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks for the following subjects ");
		System.out.print("Tamil :");
		float tamil = sc.nextFloat();
		System.out.print("\nEnglish:");
		float english = sc.nextFloat();
		System.out.print("\nMaths:");
		float maths = sc.nextFloat();
		System.out.print("\nScience:");
		float science = sc.nextFloat();
		System.out.print("\nSocial:");
		float social = sc.nextFloat();
		
		if(tamil>100||tamil<0||english>100||english<0||maths>100||maths<0||science>100||science<0||social>100||social<0) {
			System.out.println("Enter valid marks and try again");
			main(args);
		}
		else {
			Grade g = new Grade(tamil, english, maths, science, social);
			
			g.calculateTotalMarks();
			g.calculateAverageMarks();
			g.assignGrade();
			
			System.out.println("\nTotal: "+g.getTotal());
			System.out.println("Average Percentage: "+g.getAverage());
			System.out.println("Grade: "+g.getGrade());
			
		}
		
		
		
		sc.close();
	}
}
