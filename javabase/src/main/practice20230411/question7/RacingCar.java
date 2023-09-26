package main.practice20230411.question7;

import java.util.Random;

public class RacingCar extends Thread {

	private static final int GOAL = 100;

	private String name;
	private int maxDistance;
	private int engineStop;

	public RacingCar(String name, int maxDistance, int engineStop) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.engineStop = engineStop;
	}

	@Override
	public void run() {
		int totalMileage = 0;
		int mileage = 0;
		Random rm = new Random();
		while (true) {
			try {
				sleep(1000);

				if (rm.nextInt(engineStop) == 0) {
					System.out.println(this.name + "がエンストしました！");

					sleep(3000);

				} else {
					mileage = rm.nextInt(maxDistance) + 1;
					System.out.println(this.name + "が" + mileage + "km走行しました！");
					totalMileage += mileage;
				}

				if(totalMileage >=GOAL) {
					break;
				}

			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
		System.out.println(this.name + "がゴールしました！");
	}

}
