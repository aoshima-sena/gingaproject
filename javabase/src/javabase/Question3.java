package javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author souken
 *
 */
public class Question3 {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("2つの数値を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int number1 = Integer.parseInt(str);

		String str2 = br.readLine();
		int number2 = Integer.parseInt(str2);

		System.out.println(number1 + "と" + number2 + "を掛けたものは" + (number1 * number2) + "です");
		System.out.println(number1 + "を" + number2 + "で割ったものは" + (number1 / number2) + "です");
		System.out.println(number1 + "と" + number2 + "を足したものは" + (number1 + number2) + "です");
		System.out.println(number1 + "から" + number2 + "を引いたものは" + (number1 - number2) + "です");

	}

}
