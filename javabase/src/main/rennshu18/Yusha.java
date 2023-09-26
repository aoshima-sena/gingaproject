package main.rennshu18;

public class Yusha {

	String name;
	int atk;
	int hp;
	Buki buki;

	public Yusha(String name, int atk, int hp) {
		this.name = name;
		this.atk = atk;
		this.hp = hp;
	}

	public void displayStatus() {
		System.out.println("勇者 : " + name);
		System.out.println("HP : " + hp);
		if (buki == null) {
			System.out.println("攻撃力:" + this.atk);
		} else {
			System.out.println("攻撃力:" + this.atk + "  "
					+ "+" + Buki.atk);
		}
	}
}
