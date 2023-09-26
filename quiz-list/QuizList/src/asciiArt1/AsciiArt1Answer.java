package asciiArt1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiArt1Answer {
	/*
	 * 整数を入力して以下の実行結果のように「＊（全角アスタリスク）」で×を表示するプログラムを作成して下さい。
	 * また入力された値が偶数の場合×が交差する箇所を「〇（全角マル」に置き換えて表示し、
	 * 整数以外の入力がされたら適切なメッセージを表示し再度入力を求めるようにして下さい。
	 */

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int num;

			//整数を入力
			while (true) {
				try {
					num = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("整数を入力してください");
				}
			}

			//表示処理
			for (int i = 0, j = num; (i <= num) && (j >= 0); i++, j--) {
				StringBuilder line = new StringBuilder();
				//一行ずつ作っては表示を繰り返す
				for (int k = 0; k <= num; k++) {
					if ((k == i) || (k == j)) {
						if (i == j) {
							line.append("〇");
						} else {
							line.append("＊");
						}
					} else {
						line.append("   ");
					}
				}
				//出力
				System.out.println(line);
			}

		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}
}
