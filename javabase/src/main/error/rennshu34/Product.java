package main.error.rennshu34;

public class Product {

	String name;
	int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return this.name + " : " + this.price + "円";

	}
}
