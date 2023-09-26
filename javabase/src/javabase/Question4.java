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
public class Question4 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		switch (str.substring(0, 1)) {
		case "山":
			System.out.println("川");
			break;
		case "川":
			System.out.println("山");
			break;
		case "楽":
			System.out.println("苦");
			break;
		case "苦":
			System.out.println("楽");
			break;
		default:
			System.out.println("？？？");
			break;
		}
	}

}
