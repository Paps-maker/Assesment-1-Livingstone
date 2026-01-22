public final class studentsystem {

    
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    public studentsystem(String studentId, String name, int age, double gpa) {
        setStudentId(studentId);
        setName(name);
        setAge(age);
        setGpa(gpa);
    }

    
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
    public void setStudentId(String studentId) {
        if (studentId != null && studentId.matches("[A-Za-z0-9]{6}")) {
            this.studentId = studentId;
        } else {
            System.out.println("studentId must be exactly 6 alphanumeric characters.");
            this.studentId = "000000";
        }
    }

    
    public void setName(String name) {
        if (name != null && name.trim().length() >= 2) {
            this.name = name.trim();
        } else {
            System.out.println("name must be at least 2 characters.");
            this.name = "Unknown"; 
        }
    }

    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("age must be between 16 and 100.");
            this.age = 16; 
        }
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println(" GPA must be between 0.0 and 4.0.");
            this.gpa = 0.0; 
        }
    }

    
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        
    }

    public static void main(String[] args) {

        studentsystem s1 = new studentsystem("A12345", "Stone", 20, 3.5);
        s1.displayInfo();

        
        studentsystem s2 = new studentsystem("12", "stone", 120, 5.0);
        s2.displayInfo();

        s2.setStudentId("B67890");
        s2.setName("Stone");
        s2.setAge(25);
        s2.setGpa(3.8);
        s2.displayInfo();
    }
}
