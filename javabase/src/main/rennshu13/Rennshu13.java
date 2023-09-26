package main.rennshu13;

public class Rennshu13 {

	public static void main(String[] args) {
		Item[] items = {

				new Buki("鉄の剣", 20),
				new Armor("皮の服", 10)

		};

		for (Item item : items) {
			item.use();
		}

	}

}
