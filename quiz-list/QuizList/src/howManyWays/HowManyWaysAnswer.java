package howManyWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowManyWaysAnswer {
	/*
	 * 正数nとxを入力し、以下の条件を満たす(a, b, c)の組の個数を出力するプログラムを作成して下さい。
	 * ただし、nとxには1以上の正数が来るとしてよい
	 *
	 * ---条件---
	 * 1<=a<b<c<=n
	 * a+b+c = x
	 * nは正数
	 * xは正数
	 *
	 * ----実行結果----
	 * 5
	 * 9
	 * 2
	 *
	 * 10
	 * 10
	 * 4
	 *
	 * 20
	 * 20
	 * 24
	 */

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(br.readLine());
			int x = Integer.parseInt(br.readLine());
			int count = 0;
			for(int a = 1; a <= n-2; a++) {
				for(int b = a+1; b <=n-1;b++) {
					for(int c = b+1; c <= n; c++) {
						if((a+b+c) == x) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}catch(IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}
}
