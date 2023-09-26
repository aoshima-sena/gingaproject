package changeMakingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangeMakingProblem {
	//以下は入力された金額に対してお釣りの最小枚数を求め出力するプログラムです。
		//指定された2箇所を修正してお釣りの枚数を求められるようにしてください。
		//年末に出した過去問です。編集する箇所が2か所ありますので内容を理解して完成させてください。
		//
		//＝＝＝＝条件＝＝＝＝
		//入力には同クラスのgetIntメソッドを使用してください。
		//結果を表示するには同クラスのprintResultメソッドを使用してください。
		//計算するには同クラスのcalcurateメソッドを使用してください。
		//お釣りの枚数は配列changesに保存してください。
		//ただし、インデックスが0の所には1円玉の枚数、1のところには5円玉の枚数、2のところには10円玉の枚数のように保存してください。
		//
		//====実行結果====
		//お釣りの硬貨の枚数をそれぞれ求めます。金額を入力してください
		//	金額=1234
		//	お釣り
		//	1円玉 : 4枚
		//	5円玉 : 0枚
		//	10円玉 : 3枚
		//	50円玉 : 0枚
		//	100円玉 : 2枚
		//	500円玉 : 2枚

		private static final int[] COINS = { 1, 5, 10, 50, 100, 500 }; // コインの種類

		public static void main(String[] args) {
			try {
				System.out.println("お釣りを支払う硬貨の枚数をそれぞれ求めます。金額を入力してください");
				//ここから

				//ここまで
			} catch (IOException e) {
				System.out.println("入力エラーが発生しました\n終了します");
			}
		}

	/**
	 * 金額を入力してお釣りの枚数を求めるメソッド
	 *
	 * @return int[]
	 * @throws IOException
	 */
	private static int[] calculate(int cost) throws IOException {
		int[] changes = new int[COINS.length];//お釣りの枚数を保存するための配列

		// ここから

		// ここまで
		return changes;
	}

	/**
	 * 硬貨の枚数を出力するメソッド
	 *
	 * @return void
	 */
	private static void printResult(int[] changes) {
		System.out.println("お釣り");

		for (int i = 0; i < changes.length; i++) {
			System.out.println(COINS[i] + "円玉 : " + changes[i] + "枚");
		}
	}

	/**
	 * 0以上の整数を取得するメソッド
	 *
	 * @param String
	 * @return int
	 * @throws IOException
	 */
	private static int getInt(String prefix) throws IOException {
		while (true) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				System.out.print(prefix);
				int value = Integer.parseInt(br.readLine());

				if (value < 0) {
					System.out.println("0以上の数字を入力してください");
					continue;
				}

				return value;
			} catch (NumberFormatException e) {
				System.out.println("整数を入力してください。");
			}
		}
	}

}
