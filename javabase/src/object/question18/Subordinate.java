package object.question18;

import java.util.Random;

public class Subordinate extends Employee {

	public Subordinate(String name) {
		this.name = name;
	}

	@Override
	public void work(String workName) throws TroubleException {
		System.out.println("今回の" + workName + "はわたくし" +
				name + "が担当致します");
		System.out.println(workName + "中・・・");
		Random r = new Random();
		// キレた場合
		if (r.nextBoolean()) {
			// トラブル発生
			System.out.println("ふざけるな、ばか野郎！");
			System.out.println();
			// トラブル例外オブジェクトのスロー
			throw new TroubleException();
		}
		// キレなかった場合
		else {
			System.out.println("今回の" + workName + "はわたくし" +
					name + "が無事任務を果たしました");
			System.out.println();
		}
	}

	public String getName() {
		return name;
	}

}
