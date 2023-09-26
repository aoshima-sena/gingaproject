package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		/**
		 * 自然数を入力して、1からその数字までを出力してください。
		ただし、3の倍数は「Fizz」、5の倍数なら「Buzz」、15の倍数は「FizzBuzz」と表示し、10の倍数で改行してください。

		＝＝＝＝条件＝＝＝＝

		- 入力値は自然数
		- 負の値や数字以外が入力されたら再び入力を求める
		 */

		while (true) {
			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String str = br.readLine();
				int num = Integer.parseInt(str);
				if (num > 0 == false) {
					System.out.println("0以上の数字を入力して下さい。");
				} else {
					for (int i = 1; i <= num; i++) {
						if (i % 15 == 0) {
							System.out.print("FizzBuzz" + " ");
						} else if (i % 5 == 0) {
							System.out.print("Buzz" + " ");
						} else if (i % 3 == 0) {
							System.out.print("Fizz" + " ");
						} else {
							System.out.print(i + " ");
						}

						if (i % 10 == 0) {
							System.out.println();
						}

					}
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください");
			}
		}
	}
}
