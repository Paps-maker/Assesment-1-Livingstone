import java.util.*;
import java.util.stream.*;

public class IntermediateOperations {

    static class Employee {
        @SuppressWarnings("FieldMayBeFinal")
        private String name;
        @SuppressWarnings("FieldMayBeFinal")
        private String department;
        @SuppressWarnings("FieldMayBeFinal")
        private double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "  Dept: " + department + "  Salary: " + salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Stone", "IT", 90000),
                new Employee("peter", "HR", 50000),
                new Employee("Chris", "IT", 120000),
                new Employee("john", "Finance", 70000),
                new Employee("canfy", "IT", 95000)
        );

        System.out.println("Filter employees in IT with salary > 90000 ");
        @SuppressWarnings("unused")
        List<Employee> filtered = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .filter(e -> e.getSalary() > 90000)
                .peek(e -> System.out.println("Filtered: " + e))
                .collect(Collectors.toList());

        System.out.println("\n Map employee names");
        @SuppressWarnings("unused")
        List<String> names = employees.stream()
                .map(Employee::getName)
                .peek(name -> System.out.println("Mapped: " + name))
                .collect(Collectors.toList());

        System.out.println("\n FlatMap example (departments to letters) ");
        List<String> letters = employees.stream()
                .map(e -> e.getDepartment().split(""))  // split department into letters
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique letters: " + letters);

        System.out.println("\nSort employees by salary descending");
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        sortedBySalary.forEach(System.out::println);

        System.out.println("\n Combined intermediate operations ");
        List<String> combined = employees.stream()
                .filter(e -> e.getSalary() > 60000)
                .peek(e -> System.out.println("Passing filter > 60000: " + e))
                .map(e -> e.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Combined result: " + combined);
    }
}
