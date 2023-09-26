package object.question6;

public class Car {

	String type;
	int number;
	double gasoline;

	//オーバーロードをコンストラクタでしている
	public Car(String type, int number, double gasoline) {
		this.type = type;
		this.number = number;
		this.gasoline = gasoline;
	}

	public Car(String type, int number) {
		this.type = type;
		this.number = number;
		this.gasoline = 5.0;
	}
	//この書き方でもいい
	//  public Car(String type, int number) {
	// this(type, number, 5.0);
	//}

	public void run(double runGasoline) {
		if (this.gasoline < runGasoline) {
			System.out.println("ナンバー" + number + "の" + type + "はガソリン不足のため走行できません");
		} else {
			System.out.println("ナンバー" + number + "の" + type + "はガソリン" + gasoline + "リットル分走行しました");
		}

	}

	public void showInfo() {
		System.out.println("車種：" + this.type + " ナンバー：" + this.number + " ガソリン：" + this.gasoline + "リットル");
	}

}
