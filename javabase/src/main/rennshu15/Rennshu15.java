package main.rennshu15;

public class Rennshu15 {

	public static void main(String[] args) {

		PercentageCoupon coupon1 = new PercentageCoupon(0.3);
		VolumeCoupon coupon2 = new VolumeCoupon(1000);
		System.out.println(Casher.payment(5000, coupon1));
		System.out.println(Casher.payment(5000, coupon2));

		PercentageCoupon coupon3 = new PercentageCoupon(0.5);
		VolumeCoupon coupon4 = new VolumeCoupon(1500);
		System.out.println(Casher.payment(5000, coupon3));
		System.out.println(Casher.payment(5000, coupon4));
	}

}
