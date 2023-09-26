package main.practice20230411.question2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListBasicPractice {

	public static void main(String[] args) {
		// 英数字単語格納用変数の宣言とArrayListオブジェクトの生成
		ArrayList<String> number = new ArrayList<String>();
		// 英数字単語の格納
		number.add("zero");
		number.add("one");
		number.add("two");
		number.add("three");
		number.add("four");
		number.add("five");
		number.add("six");
		number.add("seven");
		number.add("eight");
		number.add("nine");
		number.add("ten");
		// 英単語の入力
		System.out.println("0から10までの英単語を入力してください");

		//eclipseだと↓のやつは利用できない
		//nullでエラーになっちゃうからほかのやり方でやらないと動かない
		//	String input = System.console().readLine();
		// ここからコーディングしてください
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			//System.out.println(input);
			boolean end = false;
		for(int i = 0;i<number.size();i++) {
		if(input.equals(number.get(i)) ) {
			System.out.println(input + "の値は数値の" + i  + "です");
			end = true;

		}


		}
		if(end == false) {
			System.out.println(input +"は英単語として存在しません");



		}

	}

}
