import java.util.*;
import java.util.stream.*;

@SuppressWarnings("unused")
public class StreamCreation {

    public static void main(String[] args) {

        System.out.println(" 1. Stream from Collections");
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        Stream<String> fruitStream = fruits.stream();
        fruitStream.forEach(System.out::println);

        System.out.println("\n 2. Stream from Arrays");
        String[] colors = {"red", "green", "blue"};
        Stream<String> colorStream = Arrays.stream(colors);
        colorStream.forEach(System.out::println);

        System.out.println("\n3. Stream from Specific Patterns ");
        Stream<Integer> evenNumbers = Stream.of(2, 4, 6, 8, 10);
        evenNumbers.forEach(System.out::println);

        System.out.println("\n4. Primitive Streams with Ranges");
        IntStream rangeStream = IntStream.range(1, 6); // 1 to 5
        rangeStream.forEach(System.out::println);

        System.out.println("\n5. Infinite Streams with Limits");
        Stream<Double> randomNumbers = Stream.generate(Math::random)
                                            .limit(5);
        randomNumbers.forEach(System.out::println);

        System.out.println("\n6. Iterative Infinite Stream with Limit");
        Stream<Integer> iterativeStream = Stream.iterate(1, n -> n + 2) // odd numbers
                                               .limit(5);
        iterativeStream.forEach(System.out::println);

        System.out.println("\n7. Combined Streams");
        Stream<String> combinedStream = Stream.concat(
                Arrays.stream(new String[]{"lion", "tiger"}),
                Stream.of("bear", "wolf")
        );
        combinedStream.forEach(System.out::println);

        System.out.println("\n8. Stream from Optional");
        Optional<String> optionalValue = Optional.of("Hello Stream");
        Stream<String> optionalStream = optionalValue.stream();
        optionalStream.forEach(System.out::println);
    }
}
