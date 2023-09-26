package main.practice20230410.question14;

public class Penguin extends Bird implements Swimable {

	@Override
	public void eat() {
		System.out.println("ペンギンが魚を食べました");

	}

	@Override
	public void swim() {
		System.out.println("ペンギンがスイスイ泳いでいます。");

	}

}
