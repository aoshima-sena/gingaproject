/**
 *
 */
package javabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author souken
 *
 */
public class Question6 {

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		System.out.println("整数の個数を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int number1 = Integer.parseInt(str);

		System.out.println("整数を個数分入力して下さい");

		int[] arrayNum = new int[number1];

		for (int i = 0; i < arrayNum.length; i++) {
			String tmp = br.readLine();
			arrayNum[i] = Integer.parseInt(tmp);
		}

		int sum = 0;
		System.out.print("入力された値は ");
		for (int i = 0; i < arrayNum.length; i++) {
			System.out.print(arrayNum[i] + " ");
			sum += arrayNum[i];
		}
		System.out.println("です ");

		System.out.println("これらの平均は" + sum/arrayNum.length + "です ");

	}

}
