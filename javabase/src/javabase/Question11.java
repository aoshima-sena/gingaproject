package javabase;

/**
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author souken
 *
 */
public class Question11 {

	public static void main(String[] args) throws IOException {
		MltiplicationTable MltiplicationTable = new MltiplicationTable();
		MltiplicationTable.printMultiplicationTable();

		System.out.println("1から9までの整数を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		try {
			int num = Integer.parseInt(str);
			if (num >= 1 && num <= 9) {

				int doubleAns = Question9.calculationDouble(num);
				int totalAns = 1;
				for (int i = 1; i < num; i++) {
					totalAns = totalAns * (i + 1);
				}
				System.out.println(num + "の2倍と階乗値の積は" + doubleAns * totalAns + "です");
			} else {
				throw new IllegalArgumentException("1から9までの整数を入力して下さい");

			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("1から9までの整数を入力して下さい");

		}
	}
}
