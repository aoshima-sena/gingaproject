package main.rennshu21;

public class Member {

	String name;
	Coupon coupon;

	public Member(String name) {
		this.name = name;

	}

	//コンストラクタじゃないときはvoidが必要
	public void couponGet(Coupon coupon) {
		this.coupon = coupon;
	}

	public int useCoupon(int price) {
		return (int) (price * coupon.rate);
	}

}
