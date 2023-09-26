package supermarketIBE;

public class Waribiki implements DiscountRate{

	@Override
	public double waribiki(int price) {
		return price * 0.8;

	}

}
