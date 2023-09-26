package friday.Race;

/*
 * 車クラスを作成してください
 * 引数に3つの変数を持ったコンストラクタとrun()メソッドの中身を書いてください。
 */

//Randomクラスの使い方↴
//Random r = new Random();
//r.nextInt(数値) ←入れられた数値を最大値としてランダムの数字が出る。

//Threadクラスのsleepメソッドの使い方
//Thread.sleep(1000); ←1秒処理を待つ

public class TestRace extends Thread {
	//ゴールまでの距離を示す定数GOAL
	private static final int GOAL = 100;
	//車の名前
	String name;
	//最高走行距離
	int maxDistance;
	//安全性
	int engineStop;

	//引数に名前と最高距離とエンジンストップが入るコンストラクタを書く↴
	//ここから

	//ここまで

	//startが実行されるとrunメソッドが動く
	//runメソッドを書く↴
	@Override
	public void run() {

	}
}
