package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu3 {

	//整数値を3つ入力させ、それらの値が小さい順（等しくてもよい）に並んでいるか判定し、
	//小さい順に並んでいる場合はOK、そうなっていない場合はNGと表示するプログラムを作成せよ。

	public static void main(String[] args) throws IOException {
		System.out.println("整数を小さい順に入力してください");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();

		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = Integer.parseInt(str3);

		if (num1 < num2 && num2 < num3) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

	}
}
