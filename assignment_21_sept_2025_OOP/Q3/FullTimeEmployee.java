package assignment_21_sept_2025_OOP.Q3;

public class FullTimeEmployee extends  Employee {
    private final double baseSalary;
    private static double paidSalary;
    public  FullTimeEmployee(String employeeName, long baseSalary) {
        super(employeeName);
        this.baseSalary = baseSalary;
    }
    public double calculateSalary() {
        double allowance = baseSalary * Employee.getAllowanceRate();
        double paid =  baseSalary + allowance;
        setPaidSalary(paid);
        return paid;
    }
    private   void  setPaidSalary(double paidSal) {
        paidSalary += paidSal;
    }
    public  double getPaidSalary() {
        return paidSalary;
    }

}
