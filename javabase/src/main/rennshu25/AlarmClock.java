package main.rennshu25;

public class AlarmClock extends Clock {

	String alarmTime;

	public AlarmClock(String time) {
		super(time);
	}

	public void setAlarm(String time) {
		this.alarmTime = time;
	}

	public void alarm() {
		if (time == alarmTime) {
			System.out.println("アラームが鳴りました！");
		}

	}

}
