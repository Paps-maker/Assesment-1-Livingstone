import java.time.LocalDate;

public class SavingsAccount extends BankAccount {

    private double interestRate;
    private static final double MIN_BALANCE = 1000;
    private LocalDate lastInterestDate = LocalDate.now();

    public SavingsAccount(String accNo, String holder,
                          double balance, double interestRate)
            throws InvalidAmountException {
        super(accNo, holder, balance);

        if (balance < MIN_BALANCE)
            throw new InvalidAmountException("Minimum balance is ksh1000");

        this.interestRate = interestRate;
    }

    public void applyMonthlyInterest() {
        if (lastInterestDate.plusMonths(1).isBefore(LocalDate.now())
                || lastInterestDate.plusMonths(1).isEqual(LocalDate.now())) {

            double interest = balance * interestRate / 100;
            balance += interest;
            addTransaction("Monthly Interest", interest);
            lastInterestDate = LocalDate.now();
            System.out.println("Monthly interest applied");
        } else {
            System.out.println("Interest already applied this month");
        }
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0)
            throw new InvalidAmountException("Invalid withdrawal amount");

        if (balance - amount < MIN_BALANCE)
            throw new InsufficientFundsException("Minimum balance ksh1000 required");

        balance -= amount;
        addTransaction("Withdrawal", amount);
    }
}
