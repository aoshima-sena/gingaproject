package main.rennshu13;

public class Armor extends Item {

	public Armor(String name, int value) {
		super(name, value);

	}

	@Override
	public void use() {
		System.out.println(this.name + "を身に着けた");

		System.out.println("守備力が" + this.value + "上がった");

	}

}
