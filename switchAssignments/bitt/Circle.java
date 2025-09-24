package bitt;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
	public double calculateArea() {
		return Math.PI * this.radius * this.radius;
	}
	public double calculatePerimeter() {
		return Math.PI * this.radius * 2;
	}



}
