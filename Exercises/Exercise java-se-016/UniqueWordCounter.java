import java.util.*;

// Main Class
public class UniqueWordCounter {

    // Method to clean text 
    public static String cleanText(String text) {

        // Remove punctuation using regex
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");

       
        text = text.toLowerCase();

        return text;
    }



    public static void useHashSet(String text) {

        String cleaned = cleanText(text);

        String[] words = cleaned.split("\\s+");

        HashSet<String> uniqueWords = new HashSet<>();

        Collections.addAll(uniqueWords, words);

        System.out.println("\n HASHSET RESULT");
        System.out.println("Unique Word Count: " + uniqueWords.size());
        System.out.println("Words (unordered):");
        System.out.println(uniqueWords);
    }


    
    public static void useLinkedHashSet(String text) {

        String cleaned = cleanText(text);

        String[] words = cleaned.split("\\s+");

        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();

        Collections.addAll(uniqueWords, words);

        System.out.println("\nRESULT");
        System.out.println("Unique Word Count: " + uniqueWords.size());
        System.out.println("Words (in insertion order):");
        System.out.println(uniqueWords);
    }


    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("UNIQUE WORD COUNTER ");
        System.out.println("1. Enter your own text");
        System.out.println("2. Use predefined text");

        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String text;

        if (choice == 1) {

            System.out.println("Enter your text:");
            text = scanner.nextLine();

        } else {

            text = "Java is great! Java is powerful. Sets remove duplicates, and Java makes coding fun.";
            System.out.println("\nUsing predefined text:");
            System.out.println(text);
        }

        // Compare both Sets
        useHashSet(text);
        useLinkedHashSet(text);

        System.out.println("\nComparison:");
        System.out.println("HashSet -> Faster, does NOT maintain order.");
        System.out.println("LinkedHashSet -> Maintains insertion order.");

        scanner.close();
    }
}
