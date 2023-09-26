package com.tasks.gradecalc;

public class Grade {
	private float tamil, english, maths, science, social, total, average;
	private char grade;
	
	
	public Grade(float tamil, float english, float maths, float science, float social) {
		
		this.tamil = tamil;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.social = social;
	}
	
	public float calculateTotalMarks() {
		this.total = this.english+this.tamil+this.maths+this.science+this.social;
		return this.total;
	}
	
	public float calculateAverageMarks() {
		this.average = this.total/5;
		return this.average;
	}
	
	public float getTamil() {
		return tamil;
	}

	public void setTamil(float tamil) {
		this.tamil = tamil;
	}

	public float getEnglish() {
		return english;
	}

	public void setEnglish(float english) {
		this.english = english;
	}

	public float getMaths() {
		return maths;
	}

	public void setMaths(float maths) {
		this.maths = maths;
	}

	public float getScience() {
		return science;
	}

	public void setScience(float science) {
		this.science = science;
	}

	public float getSocial() {
		return social;
	}

	public void setSocial(float social) {
		this.social = social;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public char assignGrade() {
		if(this.average >=90) {
			this.grade = 'S';
		}
		else if(this.average < 90 && this.average >=80) {
			this.grade = 'A';
		}
		else if(this.average < 90 && this.average >=80) {
			this.grade = 'B';
		}
		else if(this.average < 80 && this.average >=70) {
			this.grade = 'C';
		}
		else if(this.average < 70 && this.average >=60) {
			this.grade = 'D';
		}
		else if(this.average < 60 && this.average >=50) {
			this.grade = 'E';
		}
		else {
			this.grade = 'F';
		}
		return this.grade;
	}
	
	

}
