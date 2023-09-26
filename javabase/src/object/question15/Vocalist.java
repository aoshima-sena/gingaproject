package object.question15;

public class Vocalist extends Musician implements Singable {

	public Vocalist(String name) {
		super(name);

	}

	public void sing() {
		System.out.println(getName() + "は熱唱しました！");
	}
}
