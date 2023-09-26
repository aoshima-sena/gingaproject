package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day25Questioin {

	public static void main(String[] args) throws IOException {

		int number2 = 1;

		int result1 = 1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		try {
			int number = Integer.parseInt(num);
			try {
				if (number <= 1) {
					System.out.println("1以上の整数を入力してください");
				}
				System.out.println("2を" + number + "乗した時の1の位は");
				for (int i = 1; i <= number; i++) {
					number += 2 * number;

				}

				number2 = number;
				result1 = number2 % 10;

				System.out.println(result1 + "です");

			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("整数を入力してください");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("整数を入力して下さい");

		}
	}

}
//1の位で並びに規則があるからその規則にのっとって書けば簡単