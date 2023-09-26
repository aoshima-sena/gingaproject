package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu2 {

	public static void main(String[] args) throws IOException {

		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = br.readLine();
			int num = Integer.parseInt(str);

			if (num % 2 == 0) {
				System.out.println("数値" + num + "は偶数です");
			} else {
				System.out.println("数値" + num + "は奇数です");
			}

		}
	}
}
