import java.util.Scanner;

public class BankApplication {

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBANK SYSTEM");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Apply Monthly Interest");
            System.out.println("7. Transaction History");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1 -> {
                        System.out.print("Acc No: ");
                        String sa = sc.next();
                        System.out.print("Name: ");
                        String sn = sc.next();
                        System.out.print("Balance: ");
                        double sb = sc.nextDouble();
                        System.out.print("Interest Rate: ");
                        double sr = sc.nextDouble();
                        bank.addAccount(new SavingsAccount(sa, sn, sb, sr));
                    }

                    case 2 -> {
                        System.out.print("Acc No: ");
                        String ca = sc.next();
                        System.out.print("Name: ");
                        String cn = sc.next();
                        System.out.print("Balance: ");
                        double cb = sc.nextDouble();
                        System.out.print("Overdraft: ");
                        double od = sc.nextDouble();
                        bank.addAccount(new CheckingAccount(ca, cn, cb, od));
                    }

                    case 3 -> {
                        System.out.print("Enter Account Number: ");
                        BankAccount accD = bank.findAccount(sc.next());
                        if (accD == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        System.out.print("Enter Amount: ");
                        accD.deposit(sc.nextDouble());
                    }

                    case 4 -> {
                        System.out.print("Enter Account Number: ");
                        BankAccount accW = bank.findAccount(sc.next());
                        if (accW == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        System.out.print("Enter Amount: ");
                        accW.withdraw(sc.nextDouble());
                    }

                    case 5 -> {
                        System.out.print("Enter Account Number: ");
                        BankAccount accB = bank.findAccount(sc.next());
                        if (accB == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        System.out.println("Balance: KSh " + accB.getBalance());
                    }

                    case 6 -> {
                        System.out.print("Enter Account Number: ");
                        BankAccount accI = bank.findAccount(sc.next());
                        if (accI instanceof SavingsAccount savingsAccount) {
                            savingsAccount.applyMonthlyInterest();
                        } else {
                            System.out.println("Not a savings account");
                        }
                    }

                    case 7 -> {
                        System.out.print("Enter Account Number: ");
                        BankAccount accT = bank.findAccount(sc.next());
                        if (accT == null) {
                            System.out.println("Account not found");
                            break;
                        }
                        accT.printTransactions();
                    }

                    case 8 -> bank.displayAccounts();

                    case 9 -> System.out.println("Exiting system...");

                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 9);
    }
}
