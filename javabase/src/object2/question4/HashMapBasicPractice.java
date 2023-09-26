package object2.question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashMapBasicPractice {
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> rankMap = new HashMap<String, Integer>();

		rankMap.put("東京都", 1);
		rankMap.put("神奈川県", 2);
		rankMap.put("大阪府", 3);
		rankMap.put("愛知県", 4);
		rankMap.put("埼玉県", 5);
		rankMap.put("千葉県", 6);
		rankMap.put("兵庫県", 7);
		rankMap.put("北海道", 8);
		rankMap.put("福岡県", 9);
		rankMap.put("静岡県", 10);

		System.out.println("人口の多い都道府県ベスト10を当ててください！");
		// 入力値変数の宣言
		//	String input;
		// 入力の受付
		//	input = System.console().readLine();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (rankMap.size() != 0) {
			String input = br.readLine();
			//順位を取得
			Integer rank = rankMap.get(input);

			if (rank != null) {
				System.out.println("正解♪");
				System.out.println(input + "は" + rank + "位です");

				rankMap.remove(input);
			} else {
				System.out.println("残念・・・");
				System.out.println(input + "はランキングに入っていません・・・");
				System.out.println("ゲームオーバー");

				break;
			}

		}

		if (rankMap.size() == 0) {
			System.out.println("おめでとうございます♪");
			System.out.println("ベスト10をすべて答えました♪");
		}
	}
}
