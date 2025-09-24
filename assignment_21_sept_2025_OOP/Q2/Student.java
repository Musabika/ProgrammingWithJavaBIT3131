package assignment_21_sept_2025_OOP.Q2;
public class Student {
    private final long ID;
    private final String name;
    private final double[] marks = new double[3];

    public Student(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void calculateAverageMarks() {
        double average = getSum() / marks.length;
        System.out.println("The average marks are " + average);
        if (average > 80)
        System.out.println("The Grade is A");
        else if (average > 60)
            System.out.println("The Grade is B");
        else if (average > 40)
            System.out.println("The Grade is C");
        else
            System.out.println("The Grade is Fail");
    }

    public String getName() {
        return name;
    }


    public double getSum() {
        double sum = 0;
        for (double a : marks) {
            sum += a;
        }
        return sum;
    }

    public void addMark(int index, double mark) {
        marks[index] = mark;
    }


}
