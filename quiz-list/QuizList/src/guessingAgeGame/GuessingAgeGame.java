package guessingAgeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingAgeGame {

	/*
	 * 年齢(整数)を入力し、入力した値が乱数で決めた年齢より大きい場合は「>はい」、小さい場合は「>いいえ」を出力し、
	 * 入力した年齢と乱数の年齢が一致するまで入力を求め、一致した場合は「>正解です」と「～回の質問で推測できました」を表示して終了するプログラムを作成してください。
	 * ただし、修正する箇所は
	 * //ここから　
	 *
	 *‘//ここまで
	 *の中を修正すること。
	 *
	 * また、0から100までの年齢を決まった区切り方をして年齢(整数)を入力していくと今回の場合は7回以下の質問で必ず推測することができます。
	 * どのように年齢を区切り、入力していけばいいのかも含めて考えてみてください。
	 *
	 * 条件
	 * 入力は同クラス内のクラスメソッドであるgetIntを使用すること
	 * 入力してもらった年齢(整数)は変数predictionに代入して使用すること
	 * 乱数で決めた年齢は変数ageに格納されているので使用すること
	 * 質問回数をカウントする変数は変数countを使用すること
	 *
	 * ---実行結果---
	年齢当てゲームを開始します
	50
	50歳未満ですか？
	>はい
	25
	25歳未満ですか？
	>いいえ
	37
	37歳未満ですか？
	>いいえ
	43
	43歳未満ですか？
	>はい
	40
	40歳未満ですか？
	>はい
	38
	38歳未満ですか？
	>いいえ
	39
	39歳未満ですか？
	>正解です
	7回の質問で推測できました
	 *
	 */

	private static final int MAX_AGE = 100; //最大年齢
	private static final int MIN_AGE = 0; //最少年齢
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int age; //乱数(推測する年齢)を保存するための変数
		int count; //質問回数を保存するための変数
		int prediction; //予想した年齢を保存するための変数

		try {
			System.out.println("年齢当てゲームを開始します");
			age = new Random().nextInt(MAX_AGE + 1);//RandomのnextIntは0から引数で指定した値 - 1までの整数を返すため+1
			count = 0;

			//ここから

			//ここまで
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

	public static int getInt() throws IOException {
		int number; //入力した値を保持するための変数

		while (true) {
			try {
				number = Integer.parseInt(br.readLine());
				if ((number < MIN_AGE) || (number > MAX_AGE)) {
					System.out.println(String.format("%dから%dの範囲で入力してください", MIN_AGE, MAX_AGE));
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("数字以外の文字が入力されました");
			}
		}

		return number;
	}

}
