package main.rennshu28;

public class LimitedMember extends Member {

	int startTime;
	int endTime;

	public LimitedMember(String name, int startTime, int endTime) {
		super(name);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int getMonthlyFee() {
		return (int) (super.getMonthlyFee() * 0.6);
	}

	@Override
	public boolean isUseable(int time) {
		if (startTime <= endTime) {
			if (time >= this.startTime && time <= this.endTime) {
				return true;
			}
			return false;
		} else {
			if ((startTime <= time && time <= 23) || (0 <= time && time <= endTime)) {
				return true;
			}

			return false;
		}
	}
}
