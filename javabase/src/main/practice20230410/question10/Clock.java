package main.practice20230410.question10;

public class Clock {

	// 時分秒
	private int hour;
	private int minute;
	private int second;

	// コンストラクタ
	public Clock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// 情報表示メソッド
	public void showData() {
		System.out.println("ただいまの時刻：" + hour + "時" + minute + "分" + second + "秒");
	}
}
