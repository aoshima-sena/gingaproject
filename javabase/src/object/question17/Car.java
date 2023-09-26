package object.question17;

public class Car {

	private int number;
	private String type;
	private double gas;

	public Car(int number, String type, double gas) {
		this.number = number;
		this.type = type;
		this.gas = gas;
	}

	public void run() throws GasolineException {
		if (gas < 0.1) {
			throw new GasolineException("ナンバー" + number + "の" + type + "ガソリン不足のため走行できません。");
		} else {
			System.out.println("ナンバー" + number + "の" + type + "は走行しています。");
			gas -= 0.1;
		}
	}
}
