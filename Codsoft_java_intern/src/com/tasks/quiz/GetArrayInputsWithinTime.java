package com.tasks.quiz;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class GetArrayInputsWithinTime {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        int numberOfInputs = 5; // You can change this to the desired number of inputs
        String[] userInputs = new String[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++) {
            System.out.println("You have 5 seconds to enter input " + (i + 1) + ":");

            final int inputIndex = i; // Store the input index in a final variable

            Timer timer = new Timer();
            TimerTask inputTask = new TimerTask() {
                @Override
                public void run() {
                    synchronized (userInputs) {
                        if (userInputs[inputIndex] == null) {
                            System.out.println("Input " + (inputIndex + 1) + " was not received.");
                            userInputs[inputIndex] = ""; // Mark input as received to avoid duplicate messages
                        }
                        userInputs.notify(); // Notify the waiting thread
                    }
                }
            };

            // Schedule the inputTask to run after 5 seconds
            timer.schedule(inputTask, 5000); // 5000 milliseconds = 5 seconds

            Future<String> inputFuture = executorService.submit(() -> {
                try {
                    String userInput = scanner.nextLine().trim(); // Trim any leading/trailing whitespace
                    return userInput.isEmpty() ? null : userInput; // Return null for empty input
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    return null;
                }
            });

            try {
                String userInput = inputFuture.get();

                if (userInput != null) {
                    userInputs[inputIndex] = userInput;
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Input " + (inputIndex + 1) + " was not received.");
                userInputs[inputIndex] = ""; // Mark input as received to avoid duplicate messages
            } finally {
                timer.cancel(); // Cancel the timer task
            }
        }

        // Close the scanner and shutdown the executor service
        scanner.close();
        executorService.shutdown();

        // Display the collected user inputs
        System.out.println("Collected user inputs:");
        for (int i = 0; i < numberOfInputs; i++) {
            if (!userInputs[i].isEmpty()) {
                System.out.println("Input " + (i + 1) + ": " + userInputs[i]);
            } else {
                System.out.println("Input " + (i + 1) + " was not provided or is empty.");
            }
        }
    }
}
