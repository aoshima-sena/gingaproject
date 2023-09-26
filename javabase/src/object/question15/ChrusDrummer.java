package object.question15;

public class ChrusDrummer extends Musician implements Singable, Playable {

	public ChrusDrummer(String name) {
		super(name);
	}

	public void sing() {
		System.out.println(getName() + "はコーラスでハモりました！");

	}

	public void play() {

		System.out.println(getName() + "はドラムを演奏しました！");
	}
}
