import java.time.LocalDate;

public class Transaction {

    private final String type;
    private final double amount;
    private final LocalDate date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | KSh " + amount;
    }
}
