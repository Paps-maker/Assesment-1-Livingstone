import java.time.LocalDate;

abstract class Payment {
    protected double amount;
    protected LocalDate paymentDate;

    public Payment(double amount, LocalDate paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // concrete method
    public boolean validateAmount() {
        return amount > 0;
    }

    // abstract
    public abstract void processPayment();
    public abstract String getPaymentDetails();
}

class CreditCardPayment extends Payment {
    private final String cardNumber;
    @SuppressWarnings("unused")
    private final String expiryDate;

    public CreditCardPayment(double amount, LocalDate paymentDate,
                             String cardNumber, String expiryDate) {
        super(amount, paymentDate);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment() {
        if (validateAmount()) {
            System.out.println("Processing credit card payment...");
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card Payment , Amount: ksh" + amount +
               " Date: " + paymentDate +
               "  Card Number: .." + cardNumber.substring(cardNumber.length() - 4);
    }
}

class PayPalPayment extends Payment {
    private final String email;

    public PayPalPayment(double amount, LocalDate paymentDate, String email) {
        super(amount, paymentDate);
        this.email = email;
    }

    @Override
    public void processPayment() {
        if (validateAmount()) {
            System.out.println("Processing PayPal payment...");
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public String getPaymentDetails() {
        return "PayPal Payment , Amount: ksh" + amount +
               " ,Date: " + paymentDate +
               " ,Email: " + email;
    }
}

class BankTransferPayment extends Payment {
    private final String accountNumber;
    private final String bankName;

    public BankTransferPayment(double amount, LocalDate paymentDate,
                               String accountNumber, String bankName) {
        super(amount, paymentDate);
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void processPayment() {
        if (validateAmount()) {
            System.out.println("Processing bank transfer payment...");
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    @Override
    public String getPaymentDetails() {
        return "Bank Transfer Payment, Amount: ksh" + amount +
               " ,Date: " + paymentDate +
               " ,Bank: " + bankName +
               " , Account Number: " + accountNumber;
    }
}

public class PaymentTest {
    public static void main(String[] args) {

        Payment[] payments = {
            new CreditCardPayment(2500, LocalDate.now(), "1234567812345678", "12/26"),
            new PayPalPayment(1500, LocalDate.now(), "user@info.com"),
            new BankTransferPayment(5000, LocalDate.now(), "9876543210", "Equity Bank")
        };

        for (Payment payment : payments) {
            payment.processPayment();                // polymorphism
            System.out.println(payment.getPaymentDetails());
          
        }
    }
}
