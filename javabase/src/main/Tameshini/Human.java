package main.Tameshini;

public class Human extends Animal {

	public Human(String name) {
		super(name);
	}



	@Override
	public void eat() {
		System.out.println(name + "はご飯を食べる");

	}
}
