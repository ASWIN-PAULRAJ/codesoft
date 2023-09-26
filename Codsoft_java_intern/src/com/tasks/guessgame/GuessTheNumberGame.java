package com.tasks.guessgame;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random random = new Random();
        int from = 1;
        int to = 100;
        int maxAttempts = 5;
        int roundsWon = 0;
       
       
        System.out.println("Welcome to Guess the Number Game!");
       
        System.out.println("Number of attempts :"+maxAttempts);
       
        System.out.println("Let's start  game! ");

       

        while (true) {
            int secretNumber = random.nextInt(to - from + 1) + from;
            int attempts = 0;
            //System.out.println(secretNumber);
            System.out.println("Guess the number between "+from+" and "+to);
            while (attempts < maxAttempts) {
                System.out.print("Guess the number (" + (maxAttempts - attempts) + " attempts remaining): ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + secretNumber);
                    roundsWon++;
                    break;
                } else if (userGuess < secretNumber || (secretNumber-userGuess)>=10) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                   
                }
                if(attempts>=5) {
                    System.out.println("The Secret number is : "+secretNumber);

                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over! You won " + roundsWon + " rounds.");
        sc.close();
    }
}