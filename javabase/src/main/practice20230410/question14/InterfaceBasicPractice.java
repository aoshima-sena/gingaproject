package main.practice20230410.question14;

public class InterfaceBasicPractice {

	public static void main(String[] args) {
		// 鳥配列オブジェクトの生成
		Bird[] birds = { new Swallow(), new Penguin(), new Atthis() };
		// 鳥たちの紹介
		// ここからコーディングしてください
		for (int i = 0; i < birds.length; i++) {
			birds[i].eat();
			if (birds[i] instanceof Swallow) {
				((Flyable) birds[i]).fly();
			} else if (birds[i] instanceof Penguin) {
				((Swimable) birds[i]).swim();
			} else {
				((Flyable) birds[i]).fly();
				((Swimable) birds[i]).swim();

			}
		}

		for(Bird bird : birds) {
			bird.eat();
			if(bird instanceof Swallow) {
				((Flyable) bird).fly();
			}else if(bird instanceof Penguin) {
				((Swimable) bird).swim();
			}else {
				((Flyable) bird).fly();
				((Swimable) bird).swim();
			}
		}
	}

}
