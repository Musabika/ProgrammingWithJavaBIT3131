package assignment_21_sept_2025_OOP.Q3;

public abstract class Employee {
    private final String employeeName;
    private final static double allowanceRate = 0.2;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }
    public static double getAllowanceRate() {
        return allowanceRate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

}
