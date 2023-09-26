package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu7 {

	private static final int ARRAY_MAX = 5;

	public static void main(String[] args) throws IOException {

		System.out.println("適当な整数を5つ入力してください");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[ARRAY_MAX];
		for (int i = 0; i < ARRAY_MAX; i++) {
			String str = br.readLine();
			num[i] = Integer.parseInt(str);
		}

		System.out.println("これらを並び替えると以下のようになります");
		//並び替え処理
		//配列の最初の列
		for (int i = 0; i < ARRAY_MAX - 1; i++) {
			//配列の次に列
			for (int j = i + 1; j < ARRAY_MAX; j++) {
				if (num[j] < num[i]) {
					int number = num[j];
					num[j] = num[i];
					num[i] = number;
				}

			}

		}

		for (int i = 0; i < ARRAY_MAX; i++) {
			System.out.println(num[i] + " ");
		}

		System.out.println("この整数の中で最大の数は" + num[4]);
		System.out.println("で最小の数は" + num[0] + "です");

	}
}
