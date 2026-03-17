import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("Supported operations: +, -, *, /");
        System.out.println("Type 'exit' to quit.\n");

        while (continueCalculating) {
            double num1 = 0;
            double num2 = 0;
            char operator = ' ';

            // Get first number with validation
            while (true) {
                System.out.print("Enter first number: ");
                String input = scanner.nextLine().trim();
                try {
                    num1 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            // Get operator with validation
            while (true) {
                System.out.print("Enter operator (+, -, *, /): ");
                String opInput = scanner.nextLine().trim();
                if (opInput.length() == 1) {
                    operator = opInput.charAt(0);
                    if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                        break;
                    }
                }
                System.out.println("Invalid operator. Please enter +, -, *, or /.");
            }

            // Get second number with validation
            while (true) {
                System.out.print("Enter second number: ");
                String input = scanner.nextLine().trim();
                try {
                    num2 = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero!");
                        validOperation = false;
                    }
                    break;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            // Ask to continue
            System.out.print("Do another calculation? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueCalculating = false;
            }
            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}