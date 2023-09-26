package main.rennshu29;

public class Cooler {
	int nowTemp;
	int goalTemp;

	public Cooler(int nowTemp) {
		this.nowTemp = nowTemp;
	}

	public void setGoalTemp(int goalTemp) {
		this.goalTemp = goalTemp;
	}

	public void adjust() {
		if (nowTemp > goalTemp) {
			this.nowTemp = this.nowTemp - 1;
			System.out.println("室温を1度下げました。");
		} else {
			System.out.println("適温です。");
		}
	}
}
