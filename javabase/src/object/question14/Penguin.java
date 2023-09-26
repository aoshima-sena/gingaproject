package object.question14;

public class Penguin extends Bird implements Swimable {

	public void eat() {
		System.out.println("ペンギンが小魚を食べました。");
	}

	public void swim() {
		System.out.println("ペンギンがスイスイ泳いでいます。");
	}
}
