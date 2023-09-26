package object.question8;

public class Pitcher extends BaseballPlayer {

	double era;

	//スーパークラスでコンストラクタを定義していないからthisを使える
	public Pitcher(String name, int uniformNumber, double battingAverage, double era) {
		this.era = era;
		this.name = name;
		this.uniformNumber = uniformNumber;
		this.battingAverage = battingAverage;
	}

	public void introduce() {
		System.out.println("選手名：" + this.name);
		System.out.println("背番号： " + this.uniformNumber);
		System.out.println("打率：" + this.battingAverage);
		System.out.println("防御率：" + this.era);
	}

}
