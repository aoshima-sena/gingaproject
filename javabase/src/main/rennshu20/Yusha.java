package main.rennshu20;

public class Yusha {

	String name;
	int atk;

	public Yusha(String name, int atk) {
		this.name = name;
		this.atk = atk;

	}

	public void attack(Monster target) {
		atk = target.hp - atk;

		System.out.println(target.name + "に" + atk + "のダメージ!");
	}
}
