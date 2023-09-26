package main.rennshu29;

public class Rennshu29 {
	public static void main(String[] args) {
		Cooler cooler = new Cooler(28);
		AirConditioner aircon = new AirConditioner(28);

		cooler.setGoalTemp(27);
		cooler.adjust();
		cooler.adjust();

		aircon.setGoalTemp(27);
		aircon.adjust();
		aircon.setGoalTemp(28);
		aircon.adjust();
		aircon.adjust();
	}
}
