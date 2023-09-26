package com.tasks.quiz;
import java.util.Scanner;
import java.util.concurrent.*;

public class GetArrayInputsWithinTime2 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        int numberOfInputs = 5; // You can change this to the desired number of inputs
        String[] userInputs = new String[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++) {
            final int inputIndex = i;

            System.out.println("You have 5 seconds to enter input " + (inputIndex + 1) + ":");

            Future<String> inputFuture = executorService.submit(() -> {
                String userInput = null;
                try {
                    userInput = scanner.nextLine().trim(); // Trim any leading/trailing whitespace
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                return userInput;
            });

            try {
                String userInput = inputFuture.get(5, TimeUnit.SECONDS);

                if (userInput != null && !userInput.isEmpty()) {
                    userInputs[inputIndex] = userInput;
                } else {
                    System.out.println("Input " + (inputIndex + 1) + " was not received.");
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                System.out.println("Input " + (inputIndex + 1) + " was not received.");
            }
        }

        // Close the scanner and shutdown the executor service
        scanner.close();
        executorService.shutdown();

        // Display the collected user inputs
        System.out.println("Collected user inputs:");
        for (int i = 0; i < numberOfInputs; i++) {
            if (userInputs[i]!=null) {
                System.out.println("Input " + (i + 1) + ": " + userInputs[i]);
            } else {
                System.out.println("Input " + (i + 1) + " was not provided or is empty.");
            }
        }
    }
}
