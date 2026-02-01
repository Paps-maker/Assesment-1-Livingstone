public class LibraryTest {
    public static void main(String[] args) {

        LibraryItem book = new Book(1, "The", "stone",
                "9780132350884", "kids");

        LibraryItem dvd = new DVD(2, "dora", "lilo",
                148, "kids");

        LibraryItem magazine = new Magazine(3, "nation", "nation",
                45, "jan 2026");

        book.checkout();
        book.displayDetails();

        System.out.println();

        dvd.displayDetails();

        System.out.println();

        magazine.displayDetails();
    }
}
