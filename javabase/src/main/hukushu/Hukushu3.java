package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("2つの数値を入力してください");

		String str1 = br.readLine();
		int num1 = Integer.parseInt(str1);

		String str2 = br.readLine();
		int num2 = Integer.parseInt(str2);

		System.out.println(num1 + "と" + num2 + "を掛けたものは" + num1 * num2 + "です");
		System.out.println(num1 + "と" + num2 + "を割ったものは" + num1 / num2 + "です");
		System.out.println(num1 + "と" + num2 + "を足したものは" + (num1 + num2) + "です");
		System.out.println(num1 + "と" + num2 + "を引いたものは" + (num1 - num2) + "です");

	}
}
