package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu11 {

	public static void main(String[] args) throws IOException {
		MultiplicationTable multi = new MultiplicationTable();
		multi.printMultiplicationTable();

		System.out.println("1から9までの整数を入力してください");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		try {
			int num = Integer.parseInt(str);
			if (num >= 1 && num <= 9) {
				int result1 = Hukushu9.calculationDouble(num);

				int result2 = 1;
				for (int i = 0; i < num; i++) {
					result2 = result2 * (i + 1);
				}
				System.out.println(num + "の2倍と階乗値の積は" + result1 * result2 + "です");
			} else {
				throw new IllegalArgumentException("1から9までの整数を入力して下さい");

			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("1から9までの整数を入力して下さい");
		}
	}

}
