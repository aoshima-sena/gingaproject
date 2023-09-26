package main.practice20230410.question5;

public class Square {

	double width;
	double height;

	public Square(double width,double height) {
		this.width = width;
		this.height = height;
	}

	public void inform() {
		System.out.println("この四角形の幅は" + this.width + "高さは" + this.height + "です。");
	}

	public double getArea() {
		return this.width * this.height;
	}

	public void addWidth(double num) {
		this.width  += num;
	}
}
