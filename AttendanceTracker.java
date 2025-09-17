import java.util.Scanner;

public class AttendanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total number of students in the class: ");
        int totalStudents = scanner.nextInt();
        int[] attendance = new int[30];
        int dayCount = 0;

        String choice = "";

        do {
            if (dayCount >= 30) {
                System.out.println("Maximum of 30 days reached.");
                break;
            }

            System.out.print("Enter number of students present for Day " + (dayCount + 1) + ": ");
            int present = scanner.nextInt();

            if (present < 0 || present > totalStudents) {
                System.out.println("Invalid number! Must be between 0 and " + totalStudents);
                continue;
            }

            attendance[dayCount] = present;
            dayCount++;

            System.out.print("Do you want to enter attendance for another day? (yes/no): ");
            choice = scanner.next();

        } while (choice.equalsIgnoreCase("yes"));

        if (dayCount == 0) {
            System.out.println("No attendance records entered.");
            return;
        }

        int totalAttendance = 0;
        int lowDays = 0;
        for (int i = 0; i < dayCount; i++) {
            totalAttendance += attendance[i];
            if (attendance[i] < (totalStudents / 2.0)) {
                lowDays++;
            }
        }
        double average = (double) totalAttendance / dayCount;
        double lowDaysPercentage = (lowDays * 100.0) / dayCount;

        System.out.println("\n--- Attendance Report ---");
        System.out.println("Day\tPresent");
        for (int i = 0; i < dayCount; i++) {
            System.out.println((i + 1) + "\t" + attendance[i]);
        }

        System.out.printf("\nAverage Attendance: %.2f students\n", average);
        System.out.printf("Days with attendance below 50%%: %d (%.2f%% of days)\n", lowDays, lowDaysPercentage);

        scanner.close();
    }
}

