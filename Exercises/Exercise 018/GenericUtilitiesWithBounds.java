import java.util.*;


class GenericUtils {

    // Find minimum in array Comparable bound
    public static <T extends Comparable<T>> T findMin(T[] array) {
        T min = array[0];
        for (T item : array) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    //Find maximum in array Comparable bound
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    //Calculate sum of numbers bound)
    public static <T extends Number> double sum(T[] numbers) {
        double total = 0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    //Sort list of comparable objects
    public static <T extends Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }

    //Filter numbers greater than a threshold no + comparable bound
    public static <T extends Number & Comparable<T>> List<T> filterGreaterThan(
            List<T> list, T threshold) {

        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (item.compareTo(threshold) > 0) {
                result.add(item);
            }
        }
        return result;
    }
}


public class GenericUtilitiesWithBounds {

    public static void main(String[] args) {

        
        Integer[] intArray = {5, 2, 9, 1, 7};
        System.out.println("Min Integer: " + GenericUtils.findMin(intArray));
        System.out.println("Max Integer: " + GenericUtils.findMax(intArray));

        String[] strArray = {"Banana", "Apple", "Mango"};
        System.out.println("Min String: " + GenericUtils.findMin(strArray));
        System.out.println("Max String: " + GenericUtils.findMax(strArray));

        
        Double[] doubleArray = {10.5, 20.0, 5.5};
        System.out.println("Sum of Doubles: " + GenericUtils.sum(doubleArray));

        Integer[] numbers = {1, 2, 3, 4};
        System.out.println("Sum of Integers: " + GenericUtils.sum(numbers));

        
        List<Integer> intList = new ArrayList<>(Arrays.asList(4, 1, 3, 2));
        GenericUtils.sortList(intList);
        System.out.println("Sorted Integer List: " + intList);

        List<String> strList = new ArrayList<>(Arrays.asList("Z", "A", "M"));
        GenericUtils.sortList(strList);
        System.out.println("Sorted String List: " + strList);

        
        List<Integer> filterList = Arrays.asList(10, 5, 20, 15, 3);
        List<Integer> filtered = GenericUtils.filterGreaterThan(filterList, 10);
        System.out.println("Numbers > 10: " + filtered);
    }
}
