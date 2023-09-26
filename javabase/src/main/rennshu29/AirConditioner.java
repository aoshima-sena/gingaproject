package main.rennshu29;

public class AirConditioner extends Cooler {

	public AirConditioner(int nowTemp) {
		super(nowTemp);
	}

	@Override
	public void adjust() {
		if (nowTemp < goalTemp) {
			nowTemp++;
			System.out.println("室温を1度上げました");
		} else {
			super.adjust();
		}
	}
}
