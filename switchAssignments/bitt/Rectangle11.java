package bitt;

public class Rectangle11 {
	private double length;
	private double width;
	
	public Rectangle11(double len, double width) {
		this.length = len;
		this.width = width;
	}
	public double calculateArea() {
		return this.length * this.width;
	}
	public double calculatePerimeter() {
		return (length + width) * 2;
	}


}
