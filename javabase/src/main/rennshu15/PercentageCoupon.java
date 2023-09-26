package main.rennshu15;

public class PercentageCoupon implements Coupon {

	double rate;

	public PercentageCoupon(double rate) {
		this.rate = rate;
	}

	@Override
	public int discount(int amount) {
		amount = (int) (amount * rate);
		return amount;
	}

}
