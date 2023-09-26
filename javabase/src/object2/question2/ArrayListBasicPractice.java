package object2.question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayListBasicPractice {

	public static void main(String[] args) throws IOException {
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
		//↓の書き方だとNull Pointer Exceptionが発生する（Eclipseでは）
		//	String input = System.console().readLine();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// ここからコーディングしてください

		boolean flag = false;

		for (int i = 0; i < number.size(); i++) {
			if (number.get(i).equals(input)) {
				System.out.println(input + "は数値の" + i + "です");
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println(input + "は英語として存在しません");
		}
	}

}
