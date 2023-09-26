package main.practice20230410.question10;

public class OverrideBasicPractice {

	public static void main(String[] args) {

        // 普通の時計オブジェクトの生成
        Clock c1 = new Clock(10, 15, 30);
        // 普通の時計の情報の表示
        c1.showData();
        System.out.println();
        // 目覚まし時計オブジェクトの生成
        AlarmClock c2 = new AlarmClock(15, 45, 20, 6, 30);
        // 目覚まし時計の情報の表示
        c2.showData();

	}

}
