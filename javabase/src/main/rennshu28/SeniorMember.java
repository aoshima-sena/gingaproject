package main.rennshu28;

public class SeniorMember extends Member {

	public SeniorMember() {
		super("シニア会員");
	}

	@Override
	public int getMonthlyFee() {
		return (int) (super.getMonthlyFee() * 0.7);
	}
}
