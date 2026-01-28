public class BankAccount {

    //static
    private static int totalAccounts = 0;              
    /**
     *
     */
    public static final String bankName = "Global Bank"; 
    public static String getBankname() {
        return bankName;
    }

    private static double interestRate = 0.05;         

    public static String getBankName() {
        return bankName;
    }

    
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; 
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void setInterestRate(double rate) {
        if (rate > 0) {
            interestRate = rate;
        }
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void applyInterest() {
        balance += balance * interestRate;
        System.out.println("Interest applied at rate: " + interestRate);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Bank Name: " + bankName +
               "\nAccount Number: " + accountNumber +
               "\nAccount Holder: " + accountHolder +
               "\nBalance: " + balance;
    }

    //MAIN 
    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("ACC001", "Living", 5000);
        BankAccount acc2 = new BankAccount("ACC002", "Stone", 10000);

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.applyInterest();

        acc2.deposit(3000);
        acc2.applyInterest();

        BankAccount.setInterestRate(0.10); 
        acc1.applyInterest();
        acc2.applyInterest();

        System.out.println("\n--- Account 1 Details ---");
        System.out.println(acc1);

        System.out.println("\n--- Account 2 Details ---");
        System.out.println(acc2);
    }
}
