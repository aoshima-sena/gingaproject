package main.practice20230411.question4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapBasicPractice {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	static int count = 0;

	public static void main(String[] args) {

		System.out.println("人口の多い都道府県ベスト10を当ててください！");
		// 入力値変数の宣言
		String input;
		// 入力の受付
		Scanner sc = new Scanner(System.in);
		while (true) {
			input = sc.nextLine();
			System.out.println(input);

			map.put("東京都", 1);
			map.put("神奈川県", 2);
			map.put("大阪府", 3);
			map.put("愛知県", 4);
			map.put("埼玉県", 5);
			map.put("千葉県", 6);
			map.put("兵庫県", 7);
			map.put("北海道", 8);
			map.put("福岡県", 9);
			map.put("静岡県", 10);
			boolean error = true;

			for (String str : map.keySet()) {
				if (str.equals(input)) {
					System.out.println("正解！");
					System.out.println(input + "は" + map.get(str) + "位です");
					count++;
					error = false;
					break;
				}

			}
			if (error) {
				System.out.println("残念．．．");
				System.out.println(input + "はランキングに入っていません．．．");
				System.out.println("ゲームオーバー");
				break;
			}
			if (count == 10) {
				System.out.println("おめでとうございます！");
				System.out.println("ベスト10をすべて答えました！");
				break;
			}
		}

	}
}
