package com.tasks.quiz;

public class QuizQuestion {
	private String question,option1,option2,option3,option4,correctAnswer,userOption;

	public String getUserOption() {
		return userOption;
	}

	public void setUserOption(String userOption) {
		this.userOption = userOption;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public QuizQuestion(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
		
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}
	
	public String printQuestion() {
		String question = this.getQuestion() + "\r\n" + "a. "+this.getOption1() +"\r\n"+ "b. "+this.getOption2() +"\r\n"
				+ "c. "+this.getOption3() +"\r\n"
				+ "d. "+this.getOption4() +"\r\n"
				+"Enter correct option : ";
		
		return question;
	}
	
	public String printResult() {
		String question = this.getQuestion() + "\r\n" + "a. "+this.getOption1() +"\r\n"+ "b. "+this.getOption2() +"\r\n"
				+ "c. "+this.getOption3() +"\r\n"
				+ "d. "+this.getOption4() +"\r\n"
				+"Correct option : "+ this.getCorrectAnswer() +"\r\n"
				+"Option selected : "+ this.getUserOption() +"\r\n";
		
		return question;
	}
	
	
	
}
