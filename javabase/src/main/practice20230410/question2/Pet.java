package main.practice20230410.question2;

public class Pet {

	private String type;
	private String name;
	private byte age;
	private boolean gender;

	public void setType(String type) {
		this.type = type;

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setAge(byte age) {
		this.age = age;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getIntroduction() {
		String temp = "";
		if (gender == true) {
			temp += "メス";
		} else {
			temp += "オス";
		}
		return this.type + "の" + this.name + "は" + temp + "で" + this.age + "です。";
	}
}
