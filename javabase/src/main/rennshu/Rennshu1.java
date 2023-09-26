package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu1 {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("整数を入力して下さい");
			String str = br.readLine();
			int num = Integer.parseInt(str);

			if (num % 2 != 0) {
				System.out.println("odd");

			} else {
				System.out.println("even");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("整数を入力して下さい");
		}
	}
}