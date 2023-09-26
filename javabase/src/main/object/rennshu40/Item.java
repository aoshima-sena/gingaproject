package main.object.rennshu40;

public class Item {

	public String name;
	public int price;


	//コンストラクタ
	public Item(String name, int price) {
		this.name = name;
		this.price = price;


	}

//デフォルトコンストラクタ
	public Item() {

	}


	//セッター
		public void setName(String name) {
			this.name = name;
		}
	//ゲッター
		public String getName() {
			return name;
		}
		public void setPrice(int num) {
			this.price = num;
		}


	public String toString() {
		return "商品名：" + this.name + " 価格：" + this.price+"     " ;
	}


}
