package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question11month11date {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		try {
			int number = Integer.parseInt(num);

			System.out.println(number);

			if (number % 2 == 0) {
				System.out.println("*" + "         " + "*");
				System.out.println(" " + "*" + "      " + "*" + " ");
				System.out.println("  " + "*" + "    " + "*" + "  ");
				System.out.println("   " + "*" + "  " + "*" + "   ");
				System.out.println("    " + "()" + "   ");
				System.out.println("   " + "*" + "  " + "*" + "   ");
				System.out.println("  " + "*" + "    " + "*" + "  ");
				System.out.println(" " + "*" + "      " + "*" + " ");
				System.out.println("*" + "         " + "*");
			} else if (number % 2 != 0) {
				System.out.println("*" + "         " + "*");
				System.out.println(" " + "*" + "      " + "*" + " ");
				System.out.println("  " + "*" + "    " + "*" + "  ");
				System.out.println("   " + "*" + "  " + "*" + "   ");
				System.out.println("    " + "*" + "   ");
				System.out.println("   " + "*" + "  " + "*" + "   ");
				System.out.println("  " + "*" + "    " + "*" + "  ");
				System.out.println(" " + "*" + "      " + "*" + " ");
				System.out.println("*" + "         " + "*");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("整数を入力してください");
		}
	}
}