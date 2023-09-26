/**
 *
 */
package javabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author souken
 *
 */
public class Question7 {

	private static final int ARRAY_MAX = 5;

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		System.out.println("適当な整数を5つ入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arrayNum = new int[ARRAY_MAX];

		for (int i = 0; i < ARRAY_MAX; i++) {
			String tmp = br.readLine();
			arrayNum[i] = Integer.parseInt(tmp);
		}
		//バブルソート
		System.out.println("これらを並べ替えると以下のようになります");
		for (int i = 0; i < ARRAY_MAX - 1; i++) {
			for (int j = i + 1; j < ARRAY_MAX; j++) {
				if (arrayNum[j] < arrayNum[i]) {
					int tmp = arrayNum[j];
					arrayNum[j] = arrayNum[i];
					arrayNum[i] = tmp;
				}
			}
		}

		for (int i = 0; i < ARRAY_MAX; i++) {
			System.out.print(arrayNum[i] + " ");

		}
		System.out.println("");
		System.out.println("この整数の中で最大の数は" + arrayNum[4] + "最小は" + arrayNum[0] + "です");

	}

}
