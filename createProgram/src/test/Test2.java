package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Test2 {
	/*
	 * 乱数を用いて鶴と亀の数を決定し、実行結果のように問題文を表示して鶴と亀の数の入力を求め、正解の場合は「正解」、不正解の場合は「不正解」と正解の数を表示するプログラムを作成してください。
	 * ただし、入力の際は正数が来るとして例外処理をしなくてよい。（余裕がある方は正数が来るまで入力を求めるようにしてみてください）
	 *
	 * ----条件----
	 * 入力する数は0以上10以下
	 * メインメソッドの先頭に以下を記述する
	 * Random random = new Random();
	 * int crane = random.nextInt(10) + 1;
	 * int turtle = random.nextInt(10) + 1;
	 *
	 * ----実行結果----
	 * 頭の数は15、足の数は48
	 *	鶴は何羽？
	 *	6
	 *	亀は何匹？
	 *	9
	 *	正解
	 *
	 * 頭の数は11、足の数は24
	 * 鶴は何羽？
	 * 10
	 *	亀は何匹？
	 *	10
	 *	不正解
	 *	正解は、鶴が10羽、亀が1匹でした
	 *
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		Random r = new Random();
		int crane = r.nextInt(10) + 1;
		int turtle = r.nextInt(10) + 1;

		int ashi = (crane * 2) + (turtle * 4);
		int atama = crane + turtle;

		System.out.println("頭の数は" + atama + "、足の数は" + ashi);

		System.out.println("鶴は何羽？");
		while (true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				String str = br.readLine();
				int num1 = Integer.parseInt(str);

				System.out.println("亀は何匹？");
				String str2 = br.readLine();
				int num2 = Integer.parseInt(str2);

				if (num1 == crane && num2 == turtle) {
					System.out.println("正解です。");
				} else {
					System.out.println("不正解です。");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("整数を入力してください。");
			}
		}
	}

}
