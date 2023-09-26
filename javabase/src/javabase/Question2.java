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
public class Question2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int number = Integer.parseInt(str);

		if (number % 2 == 0) {
			System.out.println("数値 " + number + " は偶数です");
		} else {
			System.out.println("数値 " + number + " は奇数です");

		}

	}

}
