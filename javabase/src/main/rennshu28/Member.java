package main.rennshu28;

public class Member {

	String name;
	int monthlyFee;

	public Member(String name) {
		this.name = name;
		this.monthlyFee = 8000;
	}

	public String getName() {
		return this.name;
	}

	public int getMonthlyFee() {
		return this.monthlyFee;
	}

	public boolean isUseable(int time) {
		return true;
	}

}
