package primeNumberChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumberCheckerAnswer {

	/*
	 * 0以上の正数nを入力し、その値が素数かどうかを判定するプログラムを作成してください。
	 * 条件
	 * nは0以上の値が入力されるとしてよい
	 *
	 * ----実行結果----
	 * 正数を入力してください
	 * 9949
	 * 9949は素数です
	 *
	 * 正数を入力してください
	 * 9950
	 * 9950は素数ではありません
	 */

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			boolean isPrimeNumber;//素数であるかを表すフラグ変数
			int number; //入力された値を保存する変数

			System.out.println("正数を入力してください");
			number = Integer.parseInt(br.readLine());//整数を入力
			isPrimeNumber = true;//初期状態を素数であるとする

			for(int i = 2; i < number; i++) {
				if(number % i == 0) {//割り切れる=素数ではない
					isPrimeNumber = false;//素数ではない
					break;//ループを抜ける
				}
			}

			if(isPrimeNumber) {//素数である場合
				System.out.println(String.format("%dは素数です", number));
			}else {//素数で無い場合
				System.out.println(String.format("%dは素数ではありません", number));
			}
		}catch(IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

}
