package object.question14;

public class InterfaceBasicPractice {
	public static void main(String[] args) {
		// 鳥配列オブジェクトの生成
		Bird[] birds = { new Swallow(), new Penguin(), new Atthis() };
		// 鳥たちの紹介
		// ここからコーディングしてください

		for (Bird bird : birds) {
			bird.eat();

			if (bird instanceof Flyable) {
				((Flyable) bird).fly();
			}

			if (bird instanceof Swimable) {
				((Swimable) bird).swim();
			}

			System.out.println();
		}
	}
}
