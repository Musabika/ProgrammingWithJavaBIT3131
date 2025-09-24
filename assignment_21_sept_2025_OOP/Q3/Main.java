package assignment_21_sept_2025_OOP.Q3;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static   char answer;
    public static double companyExpenses;
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Claude", 30_000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Elisa", 10_000);
       do {
           System.out.println("Calculate The salary of Employee");
           System.out.println("1. FullTime Employee, " + fullTimeEmployee.getEmployeeName() );
           System.out.println("2. PartTime Employee, " + partTimeEmployee.getEmployeeName() );
           System.out.print("Enter Your Choice: ");
           int choice = sc.nextInt();
           switch (choice) {
               case 1:
                   double salary = fullTimeEmployee.calculateSalary();
                   System.out.println("The " + fullTimeEmployee.getEmployeeName() + "`s salary: " + salary);
                   System.out.println("The total Paid Salary is: " + fullTimeEmployee.getPaidSalary());
                   companyExpenses += salary;
                   break;
               case 2:
                   System.out.print("How many Hours worked?: ");
                   int hours = sc.nextInt();
                   double wage= partTimeEmployee.calculateSalary(hours);
                   System.out.println("The hourly rate: " + partTimeEmployee.getHourlyRate() + " Wage per hour");
                   System.out.println("The total "
                           + partTimeEmployee.getEmployeeName()
                           + "`s wage with Worked Hours "
                           + hours + ": "  + wage);
                   System.out.println("Total Paid Salary" + partTimeEmployee.getPaidSalary());
                   companyExpenses += wage;
                   break;
               default:
                   System.out.println("Invalid Choice");

           }
           System.out.println("Do you want to Continue? (Y/N)");
           answer = sc.next().toLowerCase().charAt(0);
       } while (answer == 'y');
        System.out.println("Total  Company salary expenditure: " + companyExpenses);
    }
}
