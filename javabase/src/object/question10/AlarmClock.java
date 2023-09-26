package object.question10;

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

		//親クラスのメソッドを呼び出し
		//丸写しする必要ない
		super.showData();
		System.out.println("アラーム設定時刻：" + this.alarmHour + "時" + this.alarmMinute + "分");
	}

}
