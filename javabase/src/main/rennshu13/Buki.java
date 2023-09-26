package main.rennshu13;

public class Buki extends Item {

	public Buki(String name, int value) {
		super(name, value);
	}

	@Override
	public void use() {
		System.out.println(this.name + "でこうげき!!");

		System.out.println("敵に" + this.value + "のダメージ!");
	}

}
