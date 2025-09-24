package assignment_21_sept_2025_OOP.Q3;
public class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private static double paidSalary;
    public PartTimeEmployee(String employeeName, double hourlyRate) {
        super(employeeName);
        this.hourlyRate = hourlyRate;
    }
    public double calculateSalary(int hours) {
        double salary = hourlyRate * hours;
        setPaidSalary(salary);
        return salary;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public double getPaidSalary() {
        return paidSalary;
    }
    private   void  setPaidSalary(double paidSal) {
        paidSalary += paidSal;
    }

}
