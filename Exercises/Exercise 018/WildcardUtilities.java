import java.util.*;


class WildcardUtils {

    
    public static <T> List<T> mergeLists(
            List<? extends T> list1,
            List<? extends T> list2) {

        List<T> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    
    public static List<Number> filterGreaterThan(
            List<? extends Number> list, double threshold) {

        List<Number> result = new ArrayList<>();
        for (Number num : list) {
            if (num.doubleValue() > threshold) {
                result.add(num);
            }
        }
        return result;
    }


    public static void copyNumbers(
            List<? extends Number> source,
            List<? super Number> destination) {

        for (Number num : source) {
            destination.add(num);
        }
    }


    public static <T> void addAll(
            List<? extends T> source,
            List<? super T> destination) {

        for (T item : source) {
            destination.add(item);
        }
    }
}


public class WildcardUtilities {

    public static void main(String[] args) {

    
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(4.5, 5.5);

        List<Number> merged = WildcardUtils.mergeLists(ints, doubles);
        System.out.println("Merged List: " + merged);

        
        List<Integer> numbers = Arrays.asList(10, 5, 20, 3, 15);
        List<Number> filtered = WildcardUtils.filterGreaterThan(numbers, 10);
        System.out.println("Filtered (>10): " + filtered);

        
        List<Integer> sourceInts = Arrays.asList(1, 2, 3);
        List<Number> destinationNumbers = new ArrayList<>();

        WildcardUtils.copyNumbers(sourceInts, destinationNumbers);
        System.out.println("Copied Numbers: " + destinationNumbers);

        
        List<String> sourceStrings = Arrays.asList("A", "B", "C");
        List<Object> destinationObjects = new ArrayList<>();

        WildcardUtils.addAll(sourceStrings, destinationObjects);
        System.out.println("Destination Objects: " + destinationObjects);
    }
}
