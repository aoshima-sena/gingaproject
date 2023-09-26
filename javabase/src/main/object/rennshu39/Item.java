package main.object.rennshu39;

public class Item {
	public String name;
	public int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Item) {
			Item item = (Item) obj;
			if (item.name == null || this.name == null) {
				return false;
			}
			if (item.name.equals(this.name) && item.price == this.price) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
}
