package supermarketIBE;

public class Hangaku implements DiscountRate{

	@Override
	public double waribiki(int price) {

		return price * 0.5;
	}



}
