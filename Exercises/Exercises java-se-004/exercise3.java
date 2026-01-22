import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            
            boolean isPrime = true;
            
            // Prime numbers must be greater than 1
            if (number <= 1) {
                isPrime = false;
            } else {
                // Check divisibility using a loop
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            
            // Output result
            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }
    }
}
