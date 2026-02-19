import java.util.*;

public class MethodReferencePractice {

    // Utility class for static method reference
    
    static class Utils {
        static void printUpperCase(String s) {
            System.out.println(s.toUpperCase());
        }

        static int compareLength(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

   
    // Person class for constructor reference
   
    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        void greet() {
            System.out.println("Hello, my name is " + name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        
        // 1. Static Method Reference
        
        System.out.println("Static Method Reference");
        List<String> names = Arrays.asList("stone", "david", "peter");
        
        names.forEach(Utils::printUpperCase); 

        
        // 2. Constructor Reference
     
        System.out.println("\nConstructor Reference");
        List<String> nameList = Arrays.asList("john", "tim", "tom");
        
        nameList.stream()
                .map(Person::new) 
                .forEach(Person::greet); 

        
        // 3. Instance Method Reference of an Arbitrary Object of a Type
       
        System.out.println("\n Instance Method Reference of Arbitrary Object");
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
       
        fruits.sort(String::compareToIgnoreCase); 
        fruits.forEach(System.out::println);

        
        // 4. Instance Method Reference of a Particular Object
        
        System.out.println("\n Instance Method Reference of a Particular Object");
        Person p1 = new Person("Don");
        Runnable greeter = p1::greet; 
        greeter.run();

        
        // 5. Demonstrate static comparator reference
     
        System.out.println("\nStatic Comparator Method Reference");
        List<String> animals = Arrays.asList("elephant", "cat", "dog", "hippo");
        animals.sort(Utils::compareLength); 
        animals.forEach(System.out::println);
    }
}
