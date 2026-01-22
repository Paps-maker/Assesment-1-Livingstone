
class student {

  
    private String name;
    private String id;
    private int[] grades;
    private double gpa;
    private int gradeCount;

   
    public student() {
        this.name = "Unknown";
        this.id = "Not Assigned";
        this.grades = new int[10]; 
        this.gradeCount = 0;
        this.gpa = 0.0;
    }

    public student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new int[10];
        this.gradeCount = 0;
        this.gpa = 0.0;
    }


    @SuppressWarnings("OverridableMethodCallInConstructor")
    public student(String name, String id, int[] initialGrades) {
        this.name = name;
        this.id = id;
        this.grades = new int[10];
        this.gradeCount = 0;
        for (int grade : initialGrades) {
            addGrade(grade);
        }
    }

    
    public void addGrade(int grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
            calculateGPA();
        } else {
            System.out.println("Cannot add more grades, array is full.");
        }
    }

   
    public void calculateGPA() {
        if (gradeCount == 0) {
            gpa = 0.0;
            return;
        }
        int sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        gpa = (double) sum / gradeCount;
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("ID: " + id);
        System.out.print("Grades: ");
        for (int i = 0; i < gradeCount; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println("\nGPA: " + gpa);
       
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class studentsystem {

    public static void main(String[] args) {

        student s1 = new student(); 
        student s2 = new student("Stone", "S001");
        student s3 = new student("Living", "S002", new int[]{80, 90, 70});

        
        s1.addGrade(75);
        s1.addGrade(85);

        s2.addGrade(60);
        s2.addGrade(70);
        s2.addGrade(90);

      
        s1.displayStudentInfo();
        s2.displayStudentInfo();
        s3.displayStudentInfo();

        
        
    }
}
