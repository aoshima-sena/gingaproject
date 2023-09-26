package main.rennshu20;

public class Rennshu20 {

	public static void main(String[] args) {
		Yusha taro = new Yusha("タロウ", 10);
		Monster goblin = new Monster("ゴブリン", 20);
		//タロウが、アタックする、誰に？
		taro.attack(goblin);

	}

}
