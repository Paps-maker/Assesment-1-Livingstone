import java.util.LinkedList;
import java.util.Queue;

public abstract class BankAccount {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected Queue<Transaction> transactions = new LinkedList<>();

    public BankAccount(String accNo, String holder, double balance)
            throws InvalidAmountException {
        if (balance < 0)
            throw new InvalidAmountException("Initial balance cannot be negative");

        this.accountNumber = accNo;
        this.accountHolder = holder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void addTransaction(String type, double amount) {
        if (transactions.size() == 10) {
            transactions.poll(); // remove oldest
        }
        transactions.add(new Transaction(type, amount));
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Invalid deposit amount");

        balance += amount;
        addTransaction("Deposit", amount);
    }

    public abstract void withdraw(double amount)
            throws InvalidAmountException, InsufficientFundsException;

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available");
        } else {
            transactions.forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        return "Acc No: " + accountNumber +
               ", Holder: " + accountHolder +
               ", Balance: KSh " + balance;
    }
}
