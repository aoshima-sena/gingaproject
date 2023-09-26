package object.question3;

public class Person {

	private String name;
	private int age;

	public void setData(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public void introduce() {
		System.out.println("わたしの名前は" + this.name + "、年齢は" + this.age + "歳です。");
		//	return "わたしの名前は" + this.name + "、年齢は" + this.age + "歳です。";
	}

	public void compare(Person person) {
		if (age > person.getAge()) {
			System.out.println("わたくし" + name + "は、" + person.getName() + "さんより" + (age - person.getAge()) + "歳年上です。");
		} else if (age < person.getAge()) {
			System.out.println("わたくし" + name + "は、" + person.getName() + "さんより" + (person.getAge() - age) + "歳年上です。");
		} else {
			System.out.println("わたくし" + name + "は、" + person.getName() + "さんと同じ年齢です。");
		}

	}
}
