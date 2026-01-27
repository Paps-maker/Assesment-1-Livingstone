abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // abstract method
    public abstract double calculateBonus();

    // concrete method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary:Ksh" + salary);
        System.out.println("Bonus: ksh" + calculateBonus());
    }
}

class Manager extends Employee {
    private final String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
       
    }
}

class Developer extends Employee {
    private final String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
        
    }
}

class Intern extends Employee {
    private final String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public double calculateBonus() {
        return 500;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("University: " + university);
       
    }
}

public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] employees = {
            new Manager("stone", 101, 80000, "IT"),
            new Developer("living", 102, 60000, "Java"),
            new Intern("oduor", 103, 35000, "UEAB")
        };

        for (Employee emp : employees) {
            emp.displayInfo(); // polymorphism in action
        }
    }
}
