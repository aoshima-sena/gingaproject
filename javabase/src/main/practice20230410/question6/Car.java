package main.practice20230410.question6;

public class Car {

	String type;
	int number;
	double gasoline;

	public Car(String type,int number,double gasoline) {
		this.type = type;
		this.number = number;
		this.gasoline = gasoline;
	}

	public Car(String type,int number) {
		this.type = type;
		this.number = number;
		this.gasoline = 5;
	}

	public void run(double gasoline) {
		if(this.gasoline - gasoline >=0) {

			System.out.println("ナンバー"+ this.number + "の" + this.type + "ガソリン" + gasoline +"リットル文走行しました。");
			this.gasoline = this.gasoline -gasoline;
		}else {
			System.out.println("ナンバー" + this.number + "の" + this.type +"ガソリン不足のため走行できません");

		}

	}

	public void showInfo() {
		System.out.println("車種：" + this.type + " ナンバー：" + this.number + " ガソリン：" + this.gasoline + "リットル");
	}
}
