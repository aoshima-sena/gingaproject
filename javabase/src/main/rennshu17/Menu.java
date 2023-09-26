package main.rennshu17;

public class Menu {

	String name;
	int price;

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	//セットの中の単品を提示する
	public void display() {
		System.out.println(name + ":" + price + "円");
	}
}
