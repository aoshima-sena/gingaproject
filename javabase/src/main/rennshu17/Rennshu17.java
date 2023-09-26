package main.rennshu17;

public class Rennshu17 {

	public static void main(String[] args) {
		Menu sandwich = new Menu("ハンバーガー", 150);

		Menu drink = new Menu("オレンジジュース", 100);

		SetMenu burgerset = new SetMenu("ハンバーガーセット", sandwich, drink);

		burgerset.display();

	}

}
