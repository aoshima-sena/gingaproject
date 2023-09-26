package main.rennshu26;

public class RectAngle {

	int width;
	int height;

	public RectAngle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getMenseki() {
		return this.width * this.height;
	}
}
