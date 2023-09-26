package fizzBuzzProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzzProblemAnswer {

	/*
	 * 自然数を入力して、1からその数字までを出力してください。
	 * ただし、3の倍数は「Fizz」、5の倍数なら「Buzz」、15の倍数は「FizzBuzz」と表示し、10の倍数で改行してください。
	 * 条件
	 * 入力値は自然数
	 * 負の値や数字以外が入力されたら再び入力を求める
	 *
	 * 解説
	 * 最小公倍数である15から割ると想定通りの動きになる。
	 */
	public static final int MIN = 1;//最小入力値

	public static void main(String[] args) {
		int number;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("自然数を入力してください");
			while(true) {
				try {
					number = Integer.parseInt(br.readLine());
					if(number < MIN) {
						System.out.println(MIN + "以上の数字を入力してください");
						continue;
					}
					break;
				}catch(NumberFormatException e) {
					System.out.println("数字を入力してください");
				}
			}

			for(int  i = 1; i <= number; i++) {
				if(i%15 == 0) {
					System.out.print("FizzBuzz");
				}else if(i%5 == 0) {
					System.out.print("Buzz");
				}else if(i%3 == 0) {
					System.out.print("Fizz");
				}else {
					System.out.print(i);
				}
				System.out.print(" ");//間隔処理

				if(i%10 == 0) {
					System.out.println();//改行処理
				}
			}

		}catch(IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

}
