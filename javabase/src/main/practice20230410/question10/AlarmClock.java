package main.practice20230410.question10;

public class AlarmClock extends Clock {
	int alarmHour;
	int alarmMinute;

	public AlarmClock(int hour, int minute, int second, int alarmHour, int alarmMinute) {
		super(hour, minute, second);
		this.alarmHour = alarmHour;
		this.alarmMinute = alarmMinute;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("アラーム設定時刻：" + this.alarmHour + "時" + this.alarmMinute + "分");
	}

}
