public class BankTest {
    public static void main(String[] args) {

        try {
            BankAccount acc1 = new BankAccount("ACC1001", "Alice", 5000);
            BankAccount acc2 = new BankAccount("ACC1002", "Bob", 2000);

            acc1.deposit(1000);
            acc1.withdraw(1500);
            acc1.transfer(acc2, 1000);

            acc1.displayAccount();
            acc2.displayAccount();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
