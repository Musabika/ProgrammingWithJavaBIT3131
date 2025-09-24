package assignment_21_sept_2025_OOP.Q4;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Rectangle(23, 45), new Circle(6), new Triangle(12, 40)};
        for (Shape shape : shapes) {
            System.out.println("The area of " + shape.getClass().getSimpleName() + ": " + shape.calculateArea());
        }
    }
}
