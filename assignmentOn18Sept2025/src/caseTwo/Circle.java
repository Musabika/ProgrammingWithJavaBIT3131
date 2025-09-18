package caseTwo;

public class Circle {

	 private final double radius;
	    private final double pi = 3.14;
	    public Circle(double radius) {
	        this.radius = radius;
	    }
	    public double calculateArea() {
	        return pi * radius * radius;
	    }
	    public double calculateCircumference() {
	        return 2 * pi * radius;
	    }

}
