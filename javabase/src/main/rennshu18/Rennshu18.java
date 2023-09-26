package main.rennshu18;

public class Rennshu18 {

	public static void main(String[] args) {
		Yusha taro = new Yusha("タロウ", 10, 20);
		taro.displayStatus();
		System.out.println("---");
		taro.buki = new Buki("鉄の剣", 10);
		taro.displayStatus();

	}

}
