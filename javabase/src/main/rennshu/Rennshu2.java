package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);

		if (num < 10 && num > 0) {
			System.out.println("一桁の自然数です");
		} else {
			System.out.println("自然数じゃないです");
		}

	}

}
