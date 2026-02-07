import java.util.*;


class Student {

    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    private final String name;
    private final String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email.toLowerCase(); 
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " ,Name: " + name +
                " , Email: " + email;
    }
}



// Database Manager
public class StudentDatabase {


    @SuppressWarnings("FieldMayBeFinal")
    private HashMap<Integer, Student> studentMap = new HashMap<>();

   
    @SuppressWarnings("FieldMayBeFinal")
    private HashSet<String> emailSet = new HashSet<>();


    
    public void addStudent(Student student) {

        if (studentMap.containsKey(student.getId())) {
            System.out.println("ID already exists.");
            return;
        }

        if (emailSet.contains(student.getEmail())) {
            System.out.println(" EmaiL  already exists.");
            return;
        }

        studentMap.put(student.getId(), student);
        emailSet.add(student.getEmail());

        System.out.println("Student added successfully.");
    }


  
    public void findStudent(int id) {

        Student student = studentMap.get(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }


    
    public void removeStudent(int id) {

        Student student = studentMap.remove(id);

        if (student != null) {
            emailSet.remove(student.getEmail());
            System.out.println("Student removed");
        } else {
            System.out.println("Student not found.");
        }
    }


    // List All Students
    public void listAllStudents() {

        if (studentMap.isEmpty()) {
            System.out.println("No students in database.");
            return;
        }

        System.out.println("\n STUDENTS");

        for (Student s : studentMap.values()) {
            System.out.println(s);
        }

       
        System.out.println("Total Students: " + studentMap.size());
    }



    // MAIN METHOD
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDatabase db = new StudentDatabase();

        int choice;

        do {
            System.out.println("\n STUDENT DATABASE");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Remove Student");
            System.out.println("4. List All Students");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    db.addStudent(new Student(id, name, email));
                }

                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    db.findStudent(scanner.nextInt());
                }

                case 3 -> {
                    System.out.print("Enter Student ID to remove: ");
                    db.removeStudent(scanner.nextInt());
                }

                case 4 -> db.listAllStudents();

                case 5 -> System.out.println("Exiting");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
