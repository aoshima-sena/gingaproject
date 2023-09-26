package object.question5;

public class Square {

	double width;
	double height;

	public Square(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public void inform() {
		System.out.println("この四角形の幅は" + width + "、高さは" + height + "です。");
	}

	public double getArea() {
		return width * height;
	}

	public void addWidth(double delta) {
		width += delta;
	}
}
