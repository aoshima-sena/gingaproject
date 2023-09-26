package main.practice20230410.question8;

public class Pitcher extends BaseballPlayer{

	double era;

	public Pitcher (String name,int unifirmNumber,double battingAverage,double era) {
		this.name = name;
		this.uniformNumber = unifirmNumber;
		this.battingAverage = battingAverage;
		this.era = era;
	}

	public void introduce() {
		System.out.println("選手名：" + this.name);
		System.out.println("背番号；" + this.uniformNumber);
		System.out.println("打率：" + this.battingAverage);
		System.out.println("防御率：" + this.era);
	}
}
