public class DVD extends LibraryItem {
    private final int duration;
    private final String rating;

    public DVD(int itemId, String title, String author, int duration, String rating) {
        super(itemId, title, author);
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Rating: " + rating);
    }
}
