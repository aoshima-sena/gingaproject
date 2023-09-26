package javabase;

public class Person {

	protected String name;

	public Person(String name) {
		this.name = name;

	}

	public void answer() {
		System.out.println(this.name + "「いいえ、食べていません。」");
	}

	public void talkReal() {
		System.out.println(this.name + "（いいえ、食べていません。）");
	}

}
