/**
 * Calculator Application
 * Workshop 5th of july 2023
 */

package se.lexicon;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            clearScreen();
            System.out.println("Calculator Application");
            System.out.println("Please enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.println("Please enter the operator (+, -, *, /): ");
            String operator = scanner.next();
            System.out.println("Please enter the second number: ");
            double num2 = scanner.nextDouble();


            switch (operator) {
                case "+" -> System.out.println("Result: " + (num1 + num2));
                case "-" -> System.out.println("Result: " + (num1 - num2));
                case "*" -> System.out.println("Result: " + (num1 * num2));
                case "/" ->
                        System.out.println((num2 == 0) ? "Division by 0 is impossible!" : "Result: " + (num1 / num2));
                default -> System.out.println("Invalid operator!");
            }


            System.out.println("Do you want to perform another calculation? (Y/N)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("N")) {
                clearScreen();
                exit = true;
            }
        }

        System.out.println("Calculator Application closed.");
        scanner.close();  // When I read documentation on Scanner it refers often to the fact that scanner should be closed after use.

    }

    // Method to clear the screen
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");  // Linux
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


