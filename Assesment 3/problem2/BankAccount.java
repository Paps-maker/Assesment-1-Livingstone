public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new InvalidTransactionException("Invalid account number");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Invalid deposit amount");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Invalid withdrawal amount");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public void transfer(BankAccount toAccount, double amount)
            throws InsufficientFundsException, AccountNotFoundException {

        if (toAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }
        withdraw(amount);
        toAccount.deposit(amount);
    }

    public void displayAccount() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
