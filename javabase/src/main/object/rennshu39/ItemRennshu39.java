package main.object.rennshu39;

public class ItemRennshu39 {

	public String name;
	public int price;

	public ItemRennshu39(String name, int price) {
		this.name = name;
		this.price = price;

	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		//インスタンスかどうかを調べる
		if (obj instanceof ItemRennshu39) {
			//Item型に変換
			ItemRennshu39 item = (ItemRennshu39) obj;

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
