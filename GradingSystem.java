import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalStudents = 0;
        int passes = 0;
        int fails = 0;

        while (true) {
            System.out.print("Enter student's marks (0–100) or -1 to stop: ");
            int marks = scanner.nextInt();
            if (marks == -1) {
                break;
            }
            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100.");
                continue;
            }

            totalStudents++;
            String grade;
            if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B";
            } else if (marks >= 60) {
                grade = "C";
            } else if (marks >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            if (marks >= 50) {
                passes++;
            } else {
                fails++;
            }

            System.out.println("Student's Grade: " + grade);
        }

        System.out.println("\n--- Summary Report ---");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Passed: " + passes);
        System.out.println("Failed: " + fails);

        if (totalStudents > 0) {
            double passRate = (passes * 100.0) / totalStudents;
            System.out.printf("Class Pass Rate: %.2f%%\n", passRate);
        } else {
            System.out.println("No students were entered.");
        }

        scanner.close();
    }
}