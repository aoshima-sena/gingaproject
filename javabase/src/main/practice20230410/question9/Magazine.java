package main.practice20230410.question9;

public class Magazine extends Book {

	String coverPersonName;


	public Magazine(String title, int price, String coverPersonName) {
		super(title, price);
		this.coverPersonName = coverPersonName;
	}

	public void show() {
		System.out.println(getTitle() +"絶賛発売中！！");
		System.out.println("定価" + getPrice() + "円");
		System.out.println("今回の表紙；" + this.coverPersonName + "さん");
	}


}
