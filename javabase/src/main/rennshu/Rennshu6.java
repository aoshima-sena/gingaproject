package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu6 {
	//最初に2以上の整数値を入力し、次の規則で計算し、計算回数と計算結果を表示し、
	//計算結果が1になるまで繰り返すプログラムを作成せよ。
	//規則：ある値が偶数ならその値を1/2にする。奇数ならその値を3倍して1を足す。
	static int result = 0;

	public static void main(String[] args) throws IOException {
		System.out.println("2以上の整数を入力して下さい");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String str = br.readLine();
			int num = Integer.parseInt(str);
			if (num < 2) {
				System.out.println("2以上の整数を入力して下さい");

			} else {
				while (result <= 1) {
					for (int i = 0; result != 1; i++) {
						if (num % 2 == 0) {

							num = num / 2;
							System.out.println(num + "÷2=" + result);

						}

						for (int j = 0; result != 1; j++) {

							num = num * 3 + 1;
							System.out.println(num + "× 3 + 1");
						}
					}
				}
			}
			System.out.println(result);
		}
	}

	//private static void question48(int number) {
	// System.out.println("問48");
	// System.out.println("number:" + number);
	// for (int i = 1, answer = number; answer != 1; i++) {
	//    answer = answer % 2 == 0 ? answer / 2 : answer * 3 + 1;
	//   System.out.println(i + ": " + answer);
	//地獄みたいなコードになった
}
