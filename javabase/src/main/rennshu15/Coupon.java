package main.rennshu15;

public interface Coupon {

	//引数で受けとった金額から一定の値下げを行わない値下げの値を返す
	public int discount(int amount);
}
