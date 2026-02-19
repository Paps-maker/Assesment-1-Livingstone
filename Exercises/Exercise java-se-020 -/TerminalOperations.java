import java.util.*;
import java.util.stream.*;

public class TerminalOperations {

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
            return name + "  " + department + "  " + salary;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("stone", "IT", 90000),
                new Employee("liz", "HR", 50000),
                new Employee("tom", "IT", 120000),
                new Employee("David", "Finance", 70000),
                new Employee("Emil", "IT", 95000)
        );

        
        // Reduction Operations
       
        System.out.println(" Reduction Operations");

        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Total Salary: " + totalSalary);

        employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .ifPresent(e -> System.out.println("Highest Paid: " + e));

        
        // Grouping Collectors
        
        System.out.println("\nGrouping by Department");

        Map<String, List<Employee>> grouped =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        grouped.forEach((dept, list) -> {
            System.out.println(dept + " -> " + list);
        });

        
        //  Partitioning Collectors
        
        System.out.println("\n Partitioning Salary > 80000 ");

        Map<Boolean, List<Employee>> partitioned =
                employees.stream()
                        .collect(Collectors.partitioningBy(e -> e.getSalary() > 80000));

        partitioned.forEach((key, list) -> {
            System.out.println(key + " -> " + list);
        });

        
        // Finding & Matching
       
        System.out.println("\n Finding & Matching");

        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .findFirst()
                .ifPresent(e -> System.out.println("First IT Employee: " + e));

        boolean anyHighSalary = employees.stream()
                .anyMatch(e -> e.getSalary() > 100000);

        boolean allAbove40K = employees.stream()
                .allMatch(e -> e.getSalary() > 40000);

        boolean noneInSales = employees.stream()
                .noneMatch(e -> e.getDepartment().equals("Sales"));

        System.out.println("Any salary > 100000? " + anyHighSalary);
        System.out.println("All salary > 40000? " + allAbove40K);
        System.out.println("None in Sales? " + noneInSales);

       
        // Complex Collection Structures
        
        System.out.println("\n=== Department -> Total Salary Map ===");

        Map<String, Double> departmentSalaryTotals =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)
                        ));

        departmentSalaryTotals.forEach((dept, total) ->
                System.out.println(dept + " -> " + total)
        );

        
        //  Statistics & Summary
       
        System.out.println("\nSalary Statistics ");

        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
    }
}
