public class grading {

 
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    public static int findLowestGrade(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
    public static char getGradeLetter(double score) {
        if (score >= 70) {
            return 'A';
        } else if (score >= 60) {
            return 'B';
        } else if (score >= 50) {
            return 'C';
        } else if (score >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void printGradeReport(String name, int[] grades) {
        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        char letter = getGradeLetter(average);

        System.out.println(" Student Grade");
        System.out.println("Student Name: " + name);
        System.out.print("Grades: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println("\nAverage: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Final Grade: " + letter);
        System.out.println("");
    }

    public static void main(String[] args) {

        String studentName = "Stone";
        int[] grades = {78, 65, 90, 82, 56};

        printGradeReport(studentName, grades);
    }
}
