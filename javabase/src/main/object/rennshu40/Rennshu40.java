package main.object.rennshu40;

public class Rennshu40 {

	public static void main(String[] args) {
		Item item1 = new Item("りんご", 100);
		Item item2 = new Item("みかん", 200);
		Item item3 = new Item();

		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);

		//名前をセット
		item3.setName("ブドウ");
		item3.setPrice(300);

		System.out.println();
		System.out.println(item3);
		//上でセットをしてないとgetで名前をとることができない
		System.out.println(item3.getName());

	}

}
