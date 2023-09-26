package object.question9;

public class Book {
	// タイトル
	private String title;
	// 価格
	private int price;

	// コンストラクタ
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}

	// タイトル取得メソッド
	public String getTitle() {
		return title;
	}

	// 価格取得メソッド
	public int getPrice() {
		return price;
	}
}
