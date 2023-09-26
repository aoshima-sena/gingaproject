package main.Tameshini;

public abstract class Animal {


	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	abstract public  void eat();

	public void swim() {
		System.out.println(name + "は泳いだ");
	}
}
