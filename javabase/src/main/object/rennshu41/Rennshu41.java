package main.object.rennshu41;

public class Rennshu41 {
	public static void main(String[] args) {
		Triangle tri1 = new Triangle(10, 5);
		Triangle tri2 = new Triangle(10, 5);
		Triangle tri3 = new Triangle(8, 5);
		Triangle tri4 = new Triangle(10, 7);

		System.out.println(tri1.equals(tri2));
		System.out.println(tri1.equals(tri3));
		System.out.println(tri1.equals(tri4));
		System.out.println(tri1.equals("Triangle"));

		System.out.println(tri1);
		System.out.println(tri3);
	}
}
