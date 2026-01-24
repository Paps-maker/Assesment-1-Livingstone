public class CheckingAccount extends BankAccount {

    private final double overdraftLimit;

    public CheckingAccount(String accNo, String holder,
                           double balance, double overdraftLimit)
            throws InvalidAmountException {
        super(accNo, holder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0)
            throw new InvalidAmountException("Invalid withdrawal amount");

        if (balance - amount < -overdraftLimit)
            throw new InsufficientFundsException("Overdraft limit exceeded");

        balance -= amount;
        addTransaction("Withdrawal", amount);
    }

    @Override
    public String toString() {
        return super.toString() + ", Overdraft: KSh " + overdraftLimit;
    }
}
