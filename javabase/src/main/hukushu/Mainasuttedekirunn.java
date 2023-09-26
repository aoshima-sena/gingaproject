package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mainasuttedekirunn {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		int num = -12;

		String str = "あいう";

		str = "かきく";

		System.out.println(num);
		System.out.println(str);

		//番地と保存する場所が宣言される
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//保存領域に代入
		String str1 = br.readLine();
		int num1 = Integer.parseInt(str1);
		String str2 = br.readLine();

		System.out.println(num1);
		System.out.println(str2);
	}

}
