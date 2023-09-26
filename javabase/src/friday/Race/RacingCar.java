package friday.Race;

import java.util.Random;

public class RacingCar extends Thread {
	//ゴールまでの距離を示す定数GOAL
	private static final int GOAL = 100;
	//車の名前
	String name;
	//最高走行距離
	int maxDistance;
	//エンストする割合
	int engineStop;

	public RacingCar(String name, int maxDistance, int engineStop) {
		this.name = name;
		this.maxDistance = maxDistance;
		this.engineStop = engineStop;
	}

	//startが実行されるとrunメソッドが動く
	@Override
	public void run() {
		int totalMileage = 0;
		int mileage = 0;
		Random r = new Random();
		while (true) {
			try {
				if (r.nextInt(this.engineStop) == 1) {
					System.out.println(this.name + "がエンストしました！");

					Thread.sleep(3000);

				} else {
					mileage = r.nextInt(this.maxDistance) + 1;
					System.out.println(this.name + "が" + mileage + "km走行しました！");
					totalMileage += mileage;
					if (totalMileage >= GOAL) {
						break;
					}
					Thread.sleep(1000);
				}

			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
		System.out.println(this.name + "がゴールしました！");
	}

}