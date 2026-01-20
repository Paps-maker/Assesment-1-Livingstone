/* Livingstone Oduor */

import java.util.Scanner;


// P1
@SuppressWarnings("unused")
class P1{
    public P1() {
    }

    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        int c = 7;

        int sum = a + b + c;
        System.out.println("P1 - Sum of a, b, and c: " + sum);

        int product = a * b;
        System.out.println("P1 - Product of a and b: " + product);

        int expressionResult = (a + b) * c;
        System.out.println("P1 - Result of (a + b) * c: " + expressionResult);

        int remainder = a % b;
        System.out.println("P1 - Remainder when a is divided by b: " + remainder);
    }
}


// P2
@SuppressWarnings("unused")
class P2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("P2 - Enter the student's score (0-100): ");

        if (!scanner.hasNextInt()) {
            System.out.println("enter a number between 0 and 100.");
            return;
        }

        int score = scanner.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("score must be between 0 and 100.");
        } else {
            char grade;
            if (score >= 90) grade = 'A';
            else if (score >= 80) grade = 'B';
            else if (score >= 70) grade = 'C';
            else if (score >= 60) grade = 'D';
            else grade = 'F';

            System.out.println("P2 - The student's grade is: " + grade);
        }
    }
}


// P3
@SuppressWarnings("unused")
class P3 {
    public static void main(String[] args) {
        System.out.println("P3 - Numbers 1 to 20:");

        for (int i = 1; i <= 20; i++) {
            System.out.print(i + ": ");

            if (i % 2 == 0)
                System.out.print("Even");
            else
                System.out.print("Odd");

            if (i % 5 == 0)
                System.out.print(" Multiple of 5");

            System.out.println();
        }
    }
}


// P4
@SuppressWarnings("unused")
class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("P4 - Enter a positive integer: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a positive integer.");
                scanner.next();
                continue;
            }

            number = scanner.nextInt();

            if (number > 0)
                break;
            else
                System.out.println("Input must be a positive integer.");
        }

        long factorial = 1;
        int temp = number;

        while (temp > 1) {
            factorial *= temp;
            temp--;
        }

        System.out.println("P4 - Factorial of " + number + " is: " + factorial);
    }
}


// P5

@SuppressWarnings("unused")
class P5 {
    public static void main(String[] args) {
        int rows = 5;

        System.out.println("P5 - Right-Angled Triangle Pattern:");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
