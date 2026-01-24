/**
* Basic Bank Account System
* Student: Livingstone Oduor
* Date: 1/24/26
* 
* Features Implemented:
* - Complete encapsulation with validation
* - Inheritance hierarchy (Savings/Checking accounts)
* - Polymorphic account management
* - Custom exception handling
* 
* Bonus Features: Transaction History: Store last 10 transactions per account,Interest Scheduling: Automatic monthly interest

*/




import java.util.ArrayList;

public class Bank {

    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) {
        for (BankAccount a : accounts) {
            if (a.getAccountNumber().equals(acc.getAccountNumber())) {
                System.out.println("Account already exists");
                return;
            }
        }
        accounts.add(acc);
        System.out.println("Account created successfully");
    }

    public BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAccounts() {
        accounts.forEach(System.out::println);
    }
}
