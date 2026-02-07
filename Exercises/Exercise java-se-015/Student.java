import java.util.ArrayList;
import java.util.Scanner;


class StudentRecord {
    private final int id;
    private String name;
    private String grade;

    public StudentRecord(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @SuppressWarnings("override")
    public String toString() {
        return "ID: " + id + " , Name: " + name + " , Grade: " + grade;
    }
}


// Manager class
class StudentManager {

    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<StudentRecord> students = new ArrayList<>();

    public void addStudent(StudentRecord student) {

        if (findStudent(student.getId()) != null) {
            System.out.println("Student with this ID already exists");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int id) {
        StudentRecord s = findStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public StudentRecord findStudent(int id) {
        for (StudentRecord s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateStudent(int id, String name, String grade) {
        StudentRecord s = findStudent(id);

        if (s != null) {
            s.setName(name);
            s.setGrade(grade);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n Student List ");

        for (StudentRecord s : students) {
            System.out.println(s);
        }

        System.out.println("Total Students: " + students.size());
    }
}



public class Student {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n STUDENT ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Find Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

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

                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    manager.addStudent(new StudentRecord(id, name, grade));
                }

                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    manager.removeStudent(scanner.nextInt());
                }

                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    StudentRecord found = manager.findStudent(scanner.nextInt());

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Student not found.");
                }

                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();

                    manager.updateStudent(uid, newName, newGrade);
                }

                case 5 -> manager.displayAllStudents();

                case 6 -> System.out.println("Goodbye");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
