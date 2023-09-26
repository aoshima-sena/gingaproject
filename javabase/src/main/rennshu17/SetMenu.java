package main.rennshu17;

public class SetMenu {

	String name;
	Menu sandwich;
	Menu drink;

	public SetMenu(String name, Menu sandwich, Menu drink) {
		this.name = name;
		this.sandwich = sandwich;
		this.drink = drink;
	}

	public void display() {
		//セット商品名
		System.out.println(this.name);
		System.out.println("---");
		//ハンバーガー
		sandwich.display();
		drink.display();
		System.out.println("---");
		//セット商品の合計を調べる
		int price = (int) ((sandwich.price + drink.price) * 0.8);
		System.out.println("セット価格:" + price + "円");
	}
}
