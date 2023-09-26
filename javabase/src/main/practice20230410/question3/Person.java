package main.practice20230410.question3;

public class Person {

	String name;
	int age;

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
		System.out.println("わたしの名前は" + this.name + "、年齢は" + this.age + "です。");
	}

	public void compare(Person persons) {
		String tmp = "";
		if (this.age == persons.getAge()) {
			tmp = "と同じ年齢です。";
		} else if (this.age > persons.getAge()) {
			tmp = "より" + (this.age - persons.getAge()) + "歳年上です。";
		} else if (this.age < persons.getAge()) {
			tmp = "より" + (persons.getAge() - this.age) + "歳年下です。";
		}

		System.out.println("わたくし" + this.name + "は" + persons.getName() + "さん" + tmp);

	}
}
