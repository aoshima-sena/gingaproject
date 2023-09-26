package main.intafaisu;

public class Human implements Eat,Swim{

	private String name;



	public  Human(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(name +"は食べた");
	}

	@Override
	public void swim() {
		System.out.println(name + "は泳いだ");

	}


}
