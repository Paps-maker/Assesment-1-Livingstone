import java.util.Scanner;

public class Numberstatistic {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int number;
            int sum = 0;
            int count = 0;
            
            System.out.println("Enter numbers (0 to stop):");
            
            while (true) {
                number = input.nextInt();
               
                if (number == 0) {
                    break;
                }
                
                if (number < 0) {
                    continue;
                }
                
                sum += number;
                count++;
            }
            
            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Sum: " + sum);
                System.out.println("Count: " + count);
                System.out.println("Average: " + average);
            } else {
                System.out.println("No positive numbers entered.");
            }
        }
    }
}
