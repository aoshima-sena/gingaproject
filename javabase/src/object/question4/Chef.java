package object.question4;

public class Chef {
	//オーバーロード（同じメソッド名と引数の違うものなら複数使用できる）
	public String cook(Egg egg, Cheese cheese) {
		return "スクランブルエッグ";

	}

	public String cook(Rice rice, Egg egg) {
		return "オムライス";
	}

	public String cook(Rice rice, Cheese cheese) {
		return "リゾット";
	}

	public String cook(Milk milk, Egg egg) {
		return "プディング";
	}

}
