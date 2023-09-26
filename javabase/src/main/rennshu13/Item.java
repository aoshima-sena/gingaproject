package main.rennshu13;

public abstract class Item {
	//フィールド設定
	String name;
	int value;

	//Rennshuで二つを生成できるように同時にコンストラクタする
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	//useの抽象メソッド（処理を書かない）
	public abstract void use();

}
