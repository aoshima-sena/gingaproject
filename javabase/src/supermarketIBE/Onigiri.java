package supermarketIBE;

public class Onigiri {

	String name ;
	int price;


	// 120円のツナおにぎり
	// 150円の鮭おにぎり -> ２割引きシールを貼る
	// 180円の明太おにぎり -> 半額シールを貼る
	public  Onigiri(String name,int price) {
		this.name = name;
		this.price = price;
	}


	public int getPrice() {

		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;

	}

	public String getLavel() {

		return this.name;
	}

	public void setLevel(String name) {
		this.name = name;
	}





}
