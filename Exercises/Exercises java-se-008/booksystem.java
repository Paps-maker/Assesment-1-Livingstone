import java.time.LocalDate;

final class book {

    
    private final String isbn;      
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate dueDate;      

   
    public book(String isbn, String title, String author) {
        if (isbn != null && isbn.matches("\\d{4}")) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("ISBN must be exactly 4 digits.");
        }

        setTitle(title);   
        setAuthor(author);

        this.isAvailable = true;
        this.dueDate = null;
    }

    
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public LocalDate getDueDate() { return dueDate; }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title.trim();
        } else {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author.trim();
        } else {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
    }

   
    public void borrowBook(int loanDays) {
        if (isAvailable) {
            isAvailable = false;
            dueDate = LocalDate.now().plusDays(loanDays);
            System.out.println(title + " has been borrowed. Due on: " + dueDate);
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            dueDate = null;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    public boolean isOverdue() {
        if (dueDate == null) return false;
        return LocalDate.now().isAfter(dueDate);
    }

    public void displayInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
        System.out.println("Due Date: " + (dueDate != null ? dueDate : "N/A"));
        
    }
}


public class booksystem {

    public static void main(String[] args) {

        
        book b1 = new book("0001", "The hare", "living");
        book b2 = new book("0002", "hare", "stone");

        
        b1.displayInfo();
        b2.displayInfo();

        b1.borrowBook(7);
        b1.displayInfo();

        
        System.out.println("Is b1 overdue? " + b1.isOverdue());

        
        b1.returnBook();
        b1.displayInfo();

        
        b2.borrowBook(3);
        b2.displayInfo();
    }
}
