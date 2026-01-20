/**
*	Simple Console Calculator
*	Student Name:Livingstone Oduor
*	Date: 1/20/26
*	
*	Features:
*	- Basic arithmetic operations
*	- Continuous operation
*	- Error handling for division by zero
*	- Input validation
*	
*	Bonus Features: 2.	Memory Function,5.	Enhanced UI: Color output, formatted tables
*/


import java.util.Scanner;

public class Assignment_1_Livingstone_oduor_simplecal {

    //color 
    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Double memory = null;

        System.out.println(CYAN + "===== calculator =====" + RESET);

        while (running) {

            // Menu
            System.out.println(YELLOW + "\nChoose an option:" + RESET);
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Recall Memory");
            System.out.println("6. Clear Memory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println(RED + "Invalid choice Enter a number." + RESET);
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println(GREEN + " closed" + RESET);
                break;
            }

            if (choice == 5) {
                if (memory == null) {
                    System.out.println(RED + "Memory is empty." + RESET);
                } else {
                    System.out.println(GREEN + "Memory Value: " + memory + RESET);
                }
                continue;
            }

            if (choice == 6) {
                memory = null;
                System.out.println(GREEN + "Memory cleared" + RESET);
                continue;
            }

            if (choice < 1 || choice > 4) {
                System.out.println(RED + "Invalid option" + RESET);
                continue;
            }

            // 1 number
            System.out.print("Enter first number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println(RED + "Invalid number format" + RESET);
                scanner.next();
                continue;
            }
            double num1 = scanner.nextDouble();

            // 2 number
            System.out.print("Enter second number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println(RED + "Invalid number format" + RESET);
                scanner.next();
                continue;
            }
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean valid = true;
            String operator = "";

            switch (choice) {
                case 1 -> {
                    result = num1 + num2;
                    operator = "+";
                }
                case 2 -> {
                    result = num1 - num2;
                    operator = "-";
                }
                case 3 -> {
                    result = num1 * num2;
                    operator = "*";
                }
                case 4 -> {
                    if (num2 == 0) {
                        System.out.println(RED + "Error Division by zero not allowed." + RESET);
                        valid = false;
                    } else {
                        result = num1 / num2;
                        operator = "/";
                    }
                }
            }

            if (valid) {
                memory = result; 

                
                System.out.println(GREEN + "\n------------------------------");
                System.out.printf("| %-10s | %-10s |\n", "Expression", "Result");
                System.out.println("------------------------------");
                System.out.printf("| %5.2f %s %5.2f | %10.2f |\n", num1, operator, num2, result);
                System.out.println("------------------------------" + RESET);
            }
        }
    }
}
