package bitt;

public class squaree {
	private double side;

	public squaree(double side) {
		this.side = side;
	}
	public double calculateArea() {
		return this.side * this.side;
	}
	public double calculatePerimeter() {
		return this.side * 4;
	}


}
