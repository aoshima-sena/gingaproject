package sumOfDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigitsAnswer {

	/*
	 * 0以上のある数Aを入力したら、各桁の数の総和Bを求めるプログラムを作成してください。
	 * ただし、0より小さい値、数字以外の入力がされたら再入力を求めるようにして下さい。
	 *
	 * 条件
	 * Aは0以上
	 *
	 * ----実行結果----
	 * 0
	 * 0
	 *
	 * 123
	 * 6
	 *
	 * 54321
	 * 15
	 *
	 */

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int number;
			int sumOfDigits = 0;

			while(true) {
				try {
					number = Integer.parseInt(br.readLine());
					if(number < 0) {
						System.out.println("0以上の整数を入力して下さい");
						continue;
					}
					break;
				}catch(NumberFormatException e) {
					System.out.println("数字を入力してください");
				}
			}

			while(number > 0) {
				sumOfDigits += number%10;
				number /= 10;
			}

			System.out.println(sumOfDigits);

		}catch(IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

}
