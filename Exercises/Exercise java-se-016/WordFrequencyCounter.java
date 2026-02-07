import java.util.*;

public class WordFrequencyCounter {

    
    public static String cleanText(String text) {

        text = text.replaceAll("[^a-zA-Z0-9 ]", ""); 
        text = text.toLowerCase(); 

        return text;
    }


   
    public static HashMap<String, Integer> countWords(String text) {

        String cleaned = cleanText(text);

        String[] words = cleaned.split("\\s+");

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {

            if (word.isEmpty()) continue;

            
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        return wordMap;
    }


  
    public static void displayFrequencies(HashMap<String, Integer> map) {

        System.out.println("\n WORD FREQUENCIES");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        System.out.println("Total Unique Words: " + map.size());
    }


    
    public static void showMostFrequent(HashMap<String, Integer> map) {

        int maxFreq = 0;

        
        for (int freq : map.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        System.out.println("\n Most Frequent Word(s):");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                System.out.println(entry.getKey() + " (appears " + maxFreq + " times)");
            }
        }
    }



    // MAIN METHOD
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WORD FREQUENCY ");
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

            text = "Java is fast. Java is powerful, Java is widely used, and Java is fun.";
            System.out.println("\nUsing predefined text:");
            System.out.println(text);
        }

        HashMap<String, Integer> frequencies = countWords(text);

        displayFrequencies(frequencies);

        showMostFrequent(frequencies);

        scanner.close();
    }
}
