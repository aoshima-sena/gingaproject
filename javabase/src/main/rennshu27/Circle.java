package main.rennshu27;

public class Circle {

	public static final double circle = 3.14;
	private int radius;

	public Circle(int radius) {
		this.radius = radius;

	}

	public double getArea() {
		return radius * radius * circle;
	}

}
