package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day21Question {
	public static final int MIN = 1;

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		int number;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("自然数を入力してください");
		while (true) {
			try {
				number = Integer.parseInt(in.readLine());
				if (number < MIN) {
					System.out.println(MIN + "以上の数字を入力してくください");
					continue;

				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください");
			}
		}

		for (int i = 1; i <= number; i++) {

			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print("FizzBuzz");
			} else if (i % 5 == 0) {

				System.out.print("Buzz");

			} else if (i % 3 == 0) {
				System.out.print("Fizz");
			} else {
				System.out.print(i + " ");
			}

			if (i % 10 == 0) {
				System.out.println("Buzz");

			}

		}

	}
}
