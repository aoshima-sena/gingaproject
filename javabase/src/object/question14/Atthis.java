package object.question14;

public class Atthis extends Bird implements Flyable, Swimable {

	public void fly() {
		System.out.println("カワセミがスイスイ飛んでいます。");
	}

	public void eat() {
		System.out.println("カワセミが小魚を食べました。");
	}

	public void swim() {
		System.out.println("カワセミがスイスイ泳いでいます。");
	}
}
