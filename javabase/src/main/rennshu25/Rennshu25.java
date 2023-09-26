package main.rennshu25;

public class Rennshu25 {

	public static void main(String[] args) {
		Clock clock = new Clock("10:30");
		clock.showTime();

		AlarmClock alarmClock = new AlarmClock("14:30");
		alarmClock.showTime();
		alarmClock.setAlarm("14:00");
		alarmClock.alarm();
		alarmClock.setAlarm("14:30");
		alarmClock.alarm();

	}

}
