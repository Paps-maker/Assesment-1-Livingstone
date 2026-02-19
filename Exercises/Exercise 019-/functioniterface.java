public class functioniterface {

  
    // 1. Calculator Interface
  
    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b);
    }

   
    // 2. Validator Interface
   
    @FunctionalInterface
    interface Validator<T> {
        boolean validate(T input);
    }

  
    // 3. Transformer Interface
 
    @FunctionalInterface
    interface Transformer<T, R> {
        R transform(T input);
    }

   
    // 4. Logger Interface
   
    @FunctionalInterface
    interface Logger {
        void log(String message);
    }

    
    // Main Method (Testing)
    
    public static void main(String[] args) {

        // ----- Calculator -----
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;

        System.out.println("=== Calculator ===");
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 - 5 = " + subtract.calculate(10, 5));
        System.out.println("10 * 5 = " + multiply.calculate(10, 5));
        System.out.println("10 / 5 = " + divide.calculate(10, 5));

        // ----- Validator -----
        Validator<String> isNotEmpty = input -> input != null && !input.isEmpty();
        Validator<Integer> isPositive = number -> number > 0;

        System.out.println("\n=== Validator ===");
        System.out.println("Is 'Java' valid? " + isNotEmpty.validate("Java"));
        System.out.println("Is -3 positive? " + isPositive.validate(-3));

        // ----- Transformer -----
        Transformer<String, String> toUpperCase = str -> str.toUpperCase();
        Transformer<Integer, String> numberToString = num -> "Number: " + num;

        System.out.println("\n=== Transformer ===");
        System.out.println(toUpperCase.transform("livingstone"));
        System.out.println(numberToString.transform(100));

        // ----- Logger -----
        Logger logger = message -> System.out.println("LOG: " + message);

        System.out.println("\n=== Logger ===");
        logger.log("Application started");
        logger.log("All operations executed successfully!");
    }
}
