package main.rennshu24;

public class MagicFighter extends Fighter {

	int mp;

	public MagicFighter() {
		name = "魔法戦士";
		mp = 20;
	}

	@Override
	public void attack() {
		System.out.println(this.name + "の攻撃！");
		System.out.println("敵に" + (atk + mp) + "のダメージ！");

	}
}
