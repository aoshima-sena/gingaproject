package main.practice20230410.question18;

public class Boss extends Employee {

	Subordinate sub;

	public Boss(String name, Subordinate sub) {
		this.name = name;
		this.sub = sub;
	}

	@Override
	public void work(String workName) {
		System.out.println("さて、今回の" + workName + "は部下の" + sub.getName() + "に任せよう！");

		try {
			sub.work(workName);

			System.out.println(sub.getName() + "君、よくやった！");
			System.out.println("さすがわたしの右腕だ！");

		} catch (TroubleException e) {
			System.out.println("申し訳ございません．．．");
			System.out.println(sub.getName() + "が大変失礼いたしました．．．");
			System.out.println("上司のわたくし" + this.name + "の監督不行き届きでございます．．．");
		}
	}

}
