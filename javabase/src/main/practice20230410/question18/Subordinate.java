package main.practice20230410.question18;

import java.util.Random;

public class Subordinate extends Employee {

	public Subordinate(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void work(String workName) throws TroubleException {
		System.out.println("今回の" + workName + "はわたくし" + this.name + "が担当いたします");
		System.out.println(workName + "中");

		Random rm = new Random();
		if (rm.nextBoolean() == true) {
			System.out.println("ふざけるな、バカ野郎！");
			throw new TroubleException();
		} else {
			System.out.println("今回の" + workName + "はわたくし" + this.name + "が無事任務を果たしました");
		}

	}

}
