package main.practice20230410.question4;

public class Chef {


	public String cook(Egg egg,Cheese cheese) {
		return "スクランブルエッグ";
	}

	public String cook(Rice rice,Egg egg) {
		return "オムライス";

	}

	public String cook(Rice rice,Cheese cheese) {
		return "リゾット";
	}

	public String cook(Milk milk,Egg egg) {
		return "プディング";
	}
}
