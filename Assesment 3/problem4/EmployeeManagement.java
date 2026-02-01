
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

public class EmployeeManagement {

    private static String companyName;  
    private final String employeeName;
    private double salary;

    // Constructor
    public EmployeeManagement(String employeeName) {
        this.employeeName = employeeName;
        this.salary = 0; 
    }

    // Static setter/getter for company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static String getCompanyName() {
        return companyName;
    }

    // Setter with validation
    public void setSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative!");
        }
        this.salary = salary; 
    }

    public double getSalary() {
        return salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    
    public double calculateBonus() {
        return salary * 0.1;
    }

    
    public void displayEmployee() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {

        // company name
        EmployeeManagement.setCompanyName("moviedrift");

        // employee
        EmployeeManagement emp1 = new EmployeeManagement("stone");

        try {
            emp1.setSalary(50000);  
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        emp1.displayEmployee();

        System.out.println();

        
        EmployeeManagement emp2 = new EmployeeManagement("stone");
        try {
            emp2.setSalary(-1000); 
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
