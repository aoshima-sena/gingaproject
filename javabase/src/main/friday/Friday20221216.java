package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Friday20221216 {
	static String sosu;

	public static void main(String[] args) throws IOException {

		System.out.println("整数を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);

		//	for (int i = 0; i < sosu; i++) {

		if (num % 2 == 0) {
			System.out.println(num + "は素数ではありません");

		} else {
			System.out.println(num + "は素数です");
		}

		System.out.println("0以上の整数を入力して下さい");

		String str1 = br.readLine();
		int n = Integer.parseInt(str1);
		if (n > 0) {
			int[] num1 = new int[n];
			for (int i = 0; i <= n; i++) {
				if (n % 3 != 0) {
					for (int i1 = 2; i1 <= n; i1++) {
						for (int j = 2; j < i1; j++) {

						}
						System.out.println(i1);
					}
					//	num1[n] = i;
					//		num1[i] = i;
					//		System.out.print(num1[i]);
				}
			}
		} else {
			System.out.println("0以上の整数を入力して下さい");
		}
	}
}
