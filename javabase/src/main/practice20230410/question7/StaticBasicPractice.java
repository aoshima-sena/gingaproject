package main.practice20230410.question7;

public class StaticBasicPractice {

	public static void main(String[] args) {
		// ロボット総生産数の表示
		System.out.println("ロボット総生産数：" + Robot.getTotal());
		// 5体のロボットオブジェクトを作成
		// （6体目は保留）
		Robot[] robots = {
				new Robot("RX"),
				new Robot("PZ"),
				new Robot("SS"),
				new Robot("FG"),
				new Robot("VC"),
				null
		};
		// ロボット総生産数の表示
		System.out.println("ロボット総生産数：" + Robot.getTotal());
		// 6体目のロボットオブジェクトを作成
		robots[5] = new Robot("SUPER-Z");
		// ロボット総生産数の取得
		System.out.println("ロボット総生産数：" + Robot.getTotal());
		System.out.println();
		// 6体のロボットの情報を表示
		for (int i = 0; i < robots.length; i++) {
			robots[i].introduce();
		}

	}

}
