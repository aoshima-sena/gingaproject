package tsurukameZan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TsurukameZanAnswer {

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

	public static void main(String[] args) {
		Random random = new Random(); //乱数生成器
		int crane = random.nextInt(10) + 1; //0から9までの正数が返るため+1
		int turtle = random.nextInt(10) + 1; // 同様
		int sumOfHeads = crane + turtle; //頭の数
		int sumOfLegs = crane * 2 + turtle * 4; //足の数
		int answerOfCrane; //入力用
		int answerOfTurtle; //入力用

		System.out.println(String.format("頭の数は%d、足の数は%d", sumOfHeads, sumOfLegs));//問題文表示

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				try {
					System.out.println("鶴は何羽？");
					answerOfCrane = Integer.parseInt(br.readLine());//入力
					break;
				} catch (NumberFormatException e) {
					System.out.println("正数を入力してください");
				}
			}
			while (true) {
				try {
					System.out.println("亀は何匹？");
					answerOfTurtle = Integer.parseInt(br.readLine());//入力
					break;
				} catch (NumberFormatException e) {
					System.out.println("正数を入力してください");
				}
			}

			if ((answerOfTurtle == turtle) && (answerOfCrane == crane)) {//判定
				System.out.println("正解");
			} else {
				System.out.println("不正解");
				System.out.println(String.format("正解は、鶴が%d羽、亀が%d匹でした", crane, turtle));
			}
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}
}
