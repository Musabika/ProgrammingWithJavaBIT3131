package assignment_21_sept_2025_OOP.Q2;

import java.util.Scanner;

public class UniversityStore {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] students = {new Student(1, "claude"), new Student(2, "evode"), new Student(3, "adolphe")};
        char ch = 'y';
        double highestMark = 0;
        Student stud = null;
        do {
            System.out.println("Select an option");
            System.out.println("1: " + students[0].getName());
            System.out.println("2: " + students[1].getName());
            System.out.println("3: " + students[2].getName());
            System.out.println("4. Get Highest Marks" );
            System.out.print("Choose Student: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    operations(students[0]);
                    System.out.println("The Total Marks of student" + students[0].getName() + ": " + students[0].getSum() );
                    break;
                case  2:
                    operations(students[1]);
                    System.out.println("The Total Marks of student" + students[0].getName() + ": " + students[1].getSum() );
                    break;
                case 3:
                    operations(students[2]);
                    System.out.println("The Total Marks of student" + students[0].getName() + ": " + students[2].getSum() );
                    break;
                case 4:
                    for (Student student : students) {
                        if (student.getSum() > highestMark) {
                            highestMark = student.getSum();
                            stud = student;
                        }
                    }
                    if (stud != null) {
                        System.out.println("The student " + stud.getName() + "'s Highest Marks is " + highestMark);
                    }
                    break;
                case 5:
                    ch = 'n';
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        }  while (ch == 'y');
        sc.close();
    }
    public static void operations(Student student) {
        System.out.println(" Add Marks  for " + student.getName());
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Mark of Subject " + (i + 1));
            double mark = sc.nextDouble();
            student.addMark(i, mark);

        }
    }
}
