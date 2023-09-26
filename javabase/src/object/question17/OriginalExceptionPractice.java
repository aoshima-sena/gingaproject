package object.question17;

public class OriginalExceptionPractice {
	public static void main(String[] args) {
		// 自動車オブジェクトの生成
		Car mycar = new Car(123, "ロミオ", 0.8);
		// ガソリンがなくなるまで走行する
		try {
			while (true) {
				// 走行する
				mycar.run();
			}
		} catch (GasolineException e) {
			System.out.println(e.getMessage());
		}
	}
}
