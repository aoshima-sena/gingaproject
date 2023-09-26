package main.practice20230410.question15;

public class Vocalist extends Musician implements Singable{

	public Vocalist(String name) {
		super(name);

}

	@Override
	public void sing() {
		System.out.println(super.getName() + "は熱唱しました！");

	}
}
