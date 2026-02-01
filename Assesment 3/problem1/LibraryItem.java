public class LibraryItem {
    protected int itemId;
    protected String title;
    protected String author;
    protected boolean isAvailable;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " checked out.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnItem() {
        isAvailable = true;
        System.out.println(title + " returned.");
    }

    public void displayDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}
