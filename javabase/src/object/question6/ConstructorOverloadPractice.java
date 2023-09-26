package object.question6;

public class ConstructorOverloadPractice {
	public static void main(String[] args) {
		// 1台目の車インスタンス生成
		Car car1 = new Car("トント", 1234, 10.0);
		// 2台目の車インスタンス生成
		Car car2 = new Car("ファット", 6789);
		// 2台の車を走行させる
		car1.run(7.0);
		car2.run(7.0);
		// 2台の車の情報を出力
		car1.showInfo();
		car2.showInfo();
	}
}
