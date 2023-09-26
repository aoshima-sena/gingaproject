package fibonach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonachAnswer {
	/**
	 * 以下の式で表されるフィボナッチ数列においてfib(n)の値を求めるプログラムを作成してください。
	 * 解き方は3種類あります。
	 *
	 * フィボナッチ数列の式
	 * fib(0) = 0;
	 * fib(1) = 1;
	 * fib(n) = fib(n-1) + fib(n-2) (n>=2)
	 */
	public static final int MAX_LENGTH = 10000;//余裕を持たせた最大の配列の長さ
	public static final int MIN = 1;

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int number;

			while(true) {
				try {
					System.out.println("正数を入力してください");
					number = Integer.parseInt(br.readLine());

					if(number < MIN) {
						System.out.println("1以上の数字を入力してください");
						continue;
					}

					break;

				}catch(NumberFormatException e) {
					System.out.println("数字を入力して下さい");
				}
			}

			int f_n;//f(n)
			int f_n_1 = 1;//f(n-1)
			int f_n_2 = 0;//f(n-2)

			for(int i = 0; i < number; i++) {
				f_n = f_n_1 + f_n_2;
				f_n_2 = f_n_1;
				f_n_1 = f_n;
			}

			System.out.println("fib(" + number + ") = " + f_n_2 );


		}catch(IOException e) {
			System.out.println("入力エラーが発生しました。");
		}
	}

}
