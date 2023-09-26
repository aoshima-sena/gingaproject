package main.Tameshini;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);

	}


	@Override
	public void eat() {
		System.out.println(name + "はご飯をこぼした");

	}
}
