package main.practice20230410.question17;

public class Car {
	int number ;
	String type;
	double gas;

	public Car(int number ,String type,double gas) {
		this.number = number;
		this.type = type;
		this.gas = gas;
	}

	public void run ()throws GasolineException {
		if(gas <0.1) {
			throw new GasolineException("ガソリン不足のため走行できません");
		}else {

			System.out.println("ナンバー" + this.number + "の" + this.type + "は走行しています。");
			gas  = gas -0.1;
		}
	}
}
