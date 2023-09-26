package main.rennshu27;

public class Rennshu27 {

	public static void main(String[] args) {
		Circle circle = new Circle(10);
		System.out.println("半径10cmの円の面積は" + circle.getArea() + "です。");

		Cylinder cylinder = new Cylinder(8, 8);
		System.out.println("半径cmの円の面積は" + cylinder.getArea() + "平方cmです。");
		System.out.println("半径cm、高さ8cmの円柱の体積は" + cylinder.getVolume() + "立法cmです。");

	}

}
