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
public class Question9 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String in = br.readLine();
		int inputInt = Integer.parseInt(in);

		System.out.println(inputInt + "を2倍した数は" + calculationDouble(inputInt) + "です");

		System.out.println(inputInt + "を2乗した数は" + calculationSquare(inputInt) + "です");

	}

	public static  int calculationDouble(int inputInt) {

		return inputInt * 2;
	}

	public static int calculationSquare(int inputInt) {
		return inputInt * inputInt;

	}
}