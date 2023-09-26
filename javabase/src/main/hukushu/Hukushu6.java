package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu6 {

	public static void main(String[] args) throws IOException {

		System.out.println("整数の個数を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num1 = Integer.parseInt(str);

		int[] number = new int[num1];
		while (true) {
			System.out.println("整数を個数分入力して下さい");
			for (int i = 0; i < number.length; i++) {
				String str2 = br.readLine();
				number[i] = Integer.parseInt(str2);
			}
			int sum = 0;
			System.out.println("入力された値は");
			for (int j = 0; j < number.length; j++) {
				System.out.print(" " + number[j] + " ");
				sum += number[j];
			}

			System.out.println("です");

			System.out.println("これらの平均は" + sum / number.length + "です");

		}
	}
}
