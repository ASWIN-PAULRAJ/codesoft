package com.tasks.quiz;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {

	static long timer = 5000;
	List<QuizQuestion> quizQuestions;
	int marks;

	public void loadNextQuestion(QuizQuestion quizQuestion,int i) {
		Scanner sc = new Scanner(System.in);
		
		//for (int i = 0; i < quizQuestions.size(); i++) {
			int fi = i+1;
			Timer timer = new Timer();
			
            timer.schedule( new TimerTask() {
				
				@Override
				public void run() {
					//sc.close();
					if(quizQuestion.getUserOption() == null) {
						System.out.println("Not Provided");
						if(quizQuestions.size()==(fi)) {
							//sc.close();
//							this.cancel();
//							timer.cancel();
							validateAnswers();
						}
						else {
							System.out.println("but not last");
							//sc.close();
							this.cancel();
							 timer.cancel();
							startGame(fi);
						}
					}
					else {
						if(quizQuestions.size()==(fi)) {
							//sc.close();
//							this.cancel();
//							timer.cancel();
							validateAnswers();
						}
						else {
							//sc.close();
//							this.cancel();
//							 timer.cancel();
							startGame(fi);
						}
					}
				}
			},5000);
            
            QuizQuestion question = quizQuestions.get(i);
            System.out.println(question.printQuestion());
            question.setUserOption(sc.nextLine());
            timer.cancel();
           
            
       // }     
		
		sc.close();
	}
	
	private void startGame(int fi) {
		if(quizQuestions.size()>fi) {
			loadNextQuestion(quizQuestions.get(fi),fi);
			
		}
		
	}

	public void validateAnswers() {
		quizQuestions.forEach(quizQuestion -> {
			if (quizQuestion.getCorrectAnswer().equals(quizQuestion.getUserOption())) {
				marks++;
			}
		});
		printresult();
	}

	public void printresult() {
		System.out.println("Your score is " + marks);

		quizQuestions.forEach(quizQuestion -> {
			System.out.println(quizQuestion.printResult());
		});
		System.exit(0);
	}

	public static void main(String[] args) {

		QuizGame game = new QuizGame();

		game.quizQuestions = Questions.loadQuestions();
		game.startGame(0);;
		//game.loadNextQuestion();

		//game.validateAnswers();
		//game.printresult();

	}
}
