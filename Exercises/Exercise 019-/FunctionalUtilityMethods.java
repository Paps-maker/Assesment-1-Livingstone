import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalUtilityMethods {

  
    // Utility Method: Filter using Predicate
   
    public static <T> List<T> filterCollection(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

   
    // Utility Method: Transform using Function
  
    public static <T, R> List<R> transformCollection(List<T> list, Function<T, R> transformer) {
        return list.stream().map(transformer).collect(Collectors.toList());
    }

   
    // Utility Method: Process using Consumer
   
    public static <T> void processCollection(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }

   
    // Utility Method: Generate data using Supplier
 
    public static <T> List<T> generateData(int count, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    public static void main(String[] args) {

        
        // Filter with Predicate
      
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evenNumbers = filterCollection(numbers, isEven);
        System.out.println("Even numbers: " + evenNumbers);

      
        // Transform with Function
    
        Function<Integer, String> numberToString = n -> "Number: " + n;
        List<String> numberStrings = transformCollection(numbers, numberToString);
        System.out.println("Transformed numbers: " + numberStrings);

     
        // Process with Consumer
   
        Consumer<String> printConsumer = System.out::println; 
        System.out.println("Processing transformed numbers:");
        processCollection(numberStrings, printConsumer);

 
        // Generate data with Supplier
 
        Supplier<Double> randomSupplier = Math::random; 
        List<Double> randomNumbers = generateData(5, randomSupplier);
        System.out.println("Generated random numbers: " + randomNumbers);

       
        // Combine multiple operations
       
        System.out.println("Combined operations:");
        processCollection(
            transformCollection(
                filterCollection(numbers, n -> n > 15),
                n -> "Filtered & Transformed: " + n    
            ),
            System.out::println 
        );
    }
}
