public class Books extends Product {

    private String author;
    private String publisher;
    private String isbn;

    public Books(String productId, String name, double price, int stock,
                 String author, String publisher, String isbn) {
        super(productId, name, price, stock);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }

    @SuppressWarnings("override")
    public String getProductType() {
        return "Books";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
