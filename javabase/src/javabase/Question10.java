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
public class Question10 {

	public static void main(String[] args) throws IOException {

		//		while (true) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text1 = br.readLine();
		String text2 = br.readLine();

		//			for (int i = 0; i < 1; i++) {
		if (text1.equals(text2)) {

			System.out.println(text1 + "と" + text2 + "は同じ値です");
		} else {
			System.out.println(text1 + "と" + text2 + "は異なる値です");

		}

		//			}
	}

	//	}
}
