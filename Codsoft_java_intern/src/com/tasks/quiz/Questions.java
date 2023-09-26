package com.tasks.quiz;

import java.util.ArrayList;
import java.util.List;

public class Questions {
	public static List<QuizQuestion> loadQuestions() {
		List<QuizQuestion> quizQuestions = new ArrayList<QuizQuestion>();
		
		QuizQuestion q1 = new QuizQuestion("How many types of inheritance does Java Class support ?", "2", "3", "4", "5", "b");
		QuizQuestion q2 = new QuizQuestion("What is the keyword to inherit a class in a class ?", "extends", "implements", "IS-A", "none of the above", "a");
		QuizQuestion q3 = new QuizQuestion("What is the method used to print a statment in C ?", "print", "printf", "console.log", "none of the above", "b");
		QuizQuestion q4 = new QuizQuestion("Number of primitive data types in Java are", "6", "7", "8", "9", "c");
		QuizQuestion q5 = new QuizQuestion("Automatic type conversion is possible in which of the possible cases?", "Byte to int", "Int to Long", "long to int", "short to int", "b");
		
		quizQuestions.add(q1);
		quizQuestions.add(q2);
		quizQuestions.add(q3);
		quizQuestions.add(q4);
		quizQuestions.add(q5);
		
		return quizQuestions;
	}
}
