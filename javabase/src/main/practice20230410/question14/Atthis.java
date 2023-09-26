package main.practice20230410.question14;

public class Atthis  extends Bird implements Flyable,Swimable{

	@Override
	public void eat() {
		System.out.println("カワセミが小魚を食べました。");

	}

	@Override
	public void fly() {
		System.out.println("カワセミがスイスイ飛んでいます。");

	}

	@Override
	public void swim() {
		System.out.println("カワセミがスイスイ泳いでいます。");
	}




}
