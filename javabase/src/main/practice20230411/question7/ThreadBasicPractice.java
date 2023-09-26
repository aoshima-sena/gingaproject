package main.practice20230411.question7;

public class ThreadBasicPractice {
	public static void main(String[] args) {
		// 平均的な性能のnormal号
		RacingCar normal = new RacingCar("Normal号", 10, 10);
		// スピードはあるがエンストが多いgambler号
		RacingCar gambler = new RacingCar("Gambler号", 20, 3);
		// 安全面を重視したcareful号
		RacingCar careful = new RacingCar("Careful号", 5, 1000);
		// 各車一斉にスタート！！
		normal.start();
		gambler.start();
		careful.start();
		// 前車がゴールするのを待つ
		try {
			normal.join();
			gambler.join();
			careful.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("レースが終了しました");
	}

}
