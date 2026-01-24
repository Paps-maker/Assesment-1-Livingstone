
// Livingstone Oduor


//Problem 1: 

class Book {

    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isAvailable;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Book(String title, String author, String isbn, double price) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) {
        if(author == null || author.trim().isEmpty())
            throw new IllegalArgumentException("Author cannot be null or empty");
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        if(isbn == null || !isbn.matches("\\d{13}"))
            throw new IllegalArgumentException("must be exactly 13 digits");
        this.isbn = isbn;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {
        if(isAvailable) isAvailable = false;
        else System.out.println("Book is already borrowed");
    }

    public void returnBook() { isAvailable = true; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}


//Problem 2: Employee Inheritance Hierarchy


class Employee {

    private String name;
    private int id;
    private double salary;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Employee(String name, int id, double salary) {
        setName(name);
        setId(id);
        setSalary(salary);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) {
        if(id <= 0) throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if(salary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        this.salary = salary;
    }

    public double calculateBonus() { return salary * 0.05; }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }
}

final class Manager extends Employee {

    private String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        setDepartment(department);
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        if(department == null || department.trim().isEmpty())
            throw new IllegalArgumentException("Department cannot be empty");
        this.department = department;
    }

    @Override
    public double calculateBonus() { return getSalary() * 0.15; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

final class Developer extends Employee {

    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        setProgrammingLanguage(programmingLanguage);
    }

    public String getProgrammingLanguage() { return programmingLanguage; }
    public void setProgrammingLanguage(String programmingLanguage) {
        if(programmingLanguage == null || programmingLanguage.trim().isEmpty())
            throw new IllegalArgumentException("Programming language cannot be empty");
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateBonus() { return getSalary() * 0.10; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}


//Problem 3

class Calculator {

    // Method Overloading
    public int add(int a, int b) { return a + b; }               
    public double add(double a, double b) { return a + b; }      
    public int add(int a, int b, int c) { return a + b + c; }    
    public String add(String a, String b) { return a + b; }      
}

class ScientificCalculator extends Calculator {

    // Method Overriding
    @Override
    public int add(int a, int b) {
        System.out.println("Adding two integers in ScientificCalculator");
        return a + b;
    }

    // New scientific methods
    public double power(double base, double exponent) { return Math.pow(base, exponent); }
    public double squareRoot(double num) { return Math.sqrt(num); }
}

//Problem 4: Bank Account Inheritance


class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(balance);
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) {
        if(accountNumber == null || accountNumber.trim().isEmpty())
            throw new IllegalArgumentException("Account number cannot be empty");
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() { return accountHolder; }
    public void setAccountHolder(String accountHolder) {
        if(accountHolder == null || accountHolder.trim().isEmpty())
            throw new IllegalArgumentException("Account holder cannot be empty");
        this.accountHolder = accountHolder;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        this.balance = balance; 
    }

    public void deposit(double amount) {
        if(amount <= 0) { System.out.println("Deposit amount must be positive"); return; }
        balance += amount;
        System.out.println("Deposited ksh" + amount + " | New balance: ksh" + balance);
    }

    public void withdraw(double amount) {
        if(amount <= 0) { System.out.println("Withdraw amount must be positive"); return; }
        if(amount > balance) { System.out.println("Insufficient balance!"); return; }
        balance -= amount;
        System.out.println("Withdrew ksh" + amount + " | New balance: ksh" + balance);
    }
}

final class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) {
        if(interestRate < 0) throw new IllegalArgumentException("Interest rate cannot be negative");
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if(getBalance() - amount < 100) {
            System.out.println("Cannot withdraw ksh" + amount + ". Minimum balance of ksh1000 must be maintained.");
            return;
        }
        super.withdraw(amount);
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest of ksh" + interest + " applied.");
    }
}

final class CheckingAccount extends BankAccount {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        setOverdraftLimit(overdraftLimit);
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) {
        if(overdraftLimit < 0) throw new IllegalArgumentException("Overdraft limit cannot be negative");
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= 0) { System.out.println("Withdraw amount must be positive"); return; }
        if(getBalance() - amount < -overdraftLimit) {
            System.out.println("Cannot withdraw ksh" + amount + ". Overdraft limit exceeded");
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrew ksh" + amount + " | New balance: ksh" + getBalance());
    }
}


//Main Class

public class Assessment2_Livingstone {

    public static void main(String[] args) {

       
        //Problem 1
        

        System.out.println("=== Problem 1: Book Class ===");
        Book book = new Book("Goat Must Be Crazy", "Stone", "2345678901345", 200);
        System.out.println(book);
        book.borrowBook();
        System.out.println("After borrowing: " + book);
        book.returnBook();
        System.out.println("After returning: " + book);

        
        //Problem 2
        
        System.out.println("\n=== Problem 2: Employee Hierarchy ===");
        Employee emp = new Employee("Stone", 101, 50000);
        Manager mgr = new Manager("Living", 102, 80000, "IT");
        Developer dev = new Developer("oduor", 103, 60000, "Java");

        System.out.println("\nEmployee Info:");
        emp.displayInfo();

        System.out.println("\nManager Info:");
        mgr.displayInfo();

        System.out.println("\nDeveloper Info:");
        dev.displayInfo();

        
       // Problem 3
        System.out.println("\n=== Problem 3: Calculator & ScientificCalculator ===");
        Calculator calc = new Calculator();
        System.out.println("add(int, int): " + calc.add(5, 10));
        System.out.println("add(double, double): " + calc.add(5.5, 10.2));
        System.out.println("add(int, int, int): " + calc.add(1, 2, 3));
        System.out.println("add(String, String): " + calc.add("Hello ", "World"));

        ScientificCalculator sciCalc = new ScientificCalculator();
        System.out.println("\nOverriding Example:");
        System.out.println("add(int, int): " + sciCalc.add(7, 3));

        System.out.println("\nScientific Methods:");
        System.out.println("power(2, 3): " + sciCalc.power(2, 3));
        System.out.println("squareRoot(16): " + sciCalc.squareRoot(16));

        //Problem 4
        

        System.out.println("\n=== Problem 4: Bank Account Inheritance ===");
        SavingsAccount sav = new SavingsAccount("SA123", "Alice", 1000, 0.03);
        sav.deposit(500);
        sav.withdraw(200);
        sav.withdraw(1300); 
        sav.applyInterest();

        CheckingAccount chk = new CheckingAccount("CA456", "Bob", 500, 300);
        chk.deposit(200);
        chk.withdraw(600); 
        chk.withdraw(500); 

        System.out.println("\nPolymorphism Demo:");
        BankAccount account1 = new SavingsAccount("SA789", "Charlie", 1500, 0.05);
        BankAccount account2 = new CheckingAccount("CA789", "Diana", 800, 200);

        account1.withdraw(100); 
        account2.withdraw(900); 
    }
}
