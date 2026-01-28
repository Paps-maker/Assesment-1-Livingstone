import java.util.ArrayList;
import java.util.List;

public class Library {

    
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final String location;
    private final List<Book> books;

 
    public Library(String name, String location) {
        this.name = name;
        this.location = location;
        this.books = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

   
    public static class Book {
        private String isbn;
        private String title;
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        private String author;
        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        private boolean isAvailable;

        public Book(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public void setAvailable(boolean status) {
            this.isAvailable = status;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public String getIsbn() {
            return isbn;
        }

        @Override
        public String toString() {
            return "ISBN: " + isbn +
                   ", Title: " + title +
                   ", Author: " + author +
                   ", Available: " + isAvailable;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }


    public class LibraryMember {
        private String memberId;
        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private List<Book> borrowedBooks;

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }

        public void setBorrowedBooks(List<Book> borrowedBooks) {
            this.borrowedBooks = borrowedBooks;
        }

        public LibraryMember(String memberId, String name) {
            this.memberId = memberId;
            this.name = name;
            this.borrowedBooks = new ArrayList<>();
        }

        public void borrowBook(String isbn) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                    borrowedBooks.add(book);
                    book.setAvailable(false);
                    System.out.println(name + " borrowed: " + book.title);
                    return;
                }
            }
            System.out.println("Book not available or ISBN not found.");
        }

        public void returnBook(String isbn) {
            for (Book book : borrowedBooks) {
                if (book.getIsbn().equals(isbn)) {
                    book.setAvailable(true);
                    borrowedBooks.remove(book);
                    System.out.println(name + " returned: " + book.title);
                    return;
                }
            }
            System.out.println("Book not found in borrowed list.");
        }

        public void viewBorrowedBooks() {
            System.out.println("Borrowed books by " + name + ":");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }


    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    public LibraryMember registerMember(String memberId, String name) {
        System.out.println("Member registered: " + name);
        return new LibraryMember(memberId, name);
    }

    public void listBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    
    public static void main(String[] args) {

        Library library = new Library("City Library", "Nairobi");

        // Add books
        Library.Book book1 = new Library.Book("ISBN001", "The Riot", "stone");
        Library.Book book2 = new Library.Book("ISBN002", "Goat matata", "O");

        library.addBook(book1);
        library.addBook(book2);

        // Register member
        Library.LibraryMember member1 = library.registerMember("001", "oduor");

        // Borrow & return books
        member1.borrowBook("ISBN001");
        member1.viewBorrowedBooks();

        member1.returnBook("ISBN001");
        library.listBooks();
    }
}
