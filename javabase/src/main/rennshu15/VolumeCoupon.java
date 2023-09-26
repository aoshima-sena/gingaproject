package main.rennshu15;

public class VolumeCoupon implements Coupon {

	int volume;

	public VolumeCoupon(int volume) {
		this.volume = volume;

	}

	public int discount(int amount) {
		amount = amount - volume;
		return amount;
	}

}
