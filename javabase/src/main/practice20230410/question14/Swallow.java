package main.practice20230410.question14;

public class Swallow extends Bird implements Flyable{

	@Override
	public void eat() {
		System.out.println("つばめが虫を食べました。");

	}

	public void fly() {
		System.out.println("つばめがスイスイ飛んでいます。");
	}

}
