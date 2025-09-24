package assignment_21_sept_2025_OOP.Q4;

public class Triangle extends Shape {
    private final double base;
    private final double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height / 2;
    }
}
