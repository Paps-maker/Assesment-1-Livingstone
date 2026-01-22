public class bank {

    
    private String accountNumber;
    public String getAccountNumber() {
        return accountNumber;
    }

    @SuppressWarnings("unused")
    private String accountHolder;
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    private double balance;

    
    public bank() {
        accountNumber = "unknown";
        accountHolder = "unknown";
        balance = 0.0;
    }

    
    public bank(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

   
    public bank(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    
    public static void main(String[] args) {

        bank acc1 = new bank();
        bank acc2 = new bank("ACC111", "living");
        bank acc3 = new bank("ACC222", "stone", 5000);

        acc1.displayBalance();

        acc2.deposit(1000);
        acc2.withdraw(300);
        acc2.displayBalance();

        acc3.withdraw(2000);
        acc3.displayBalance();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
