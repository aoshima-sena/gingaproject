package main.rennshu27;

public class Cylinder extends Circle {

	private int height;

	public Cylinder(int radius, int height) {
		super(radius);
		this.height = height;
	}

	public double getVolume() {
		return super.getArea() * height;
	}
}
