package javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question13 {

	public static void main(String[] args) throws IOException {

		System.out.println("1つの数値を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		try {
			int num = Integer.parseInt(str);

			Calculator calculatorDouble = new CalculatorDouble();

			Calculator calculatorSquare = new CalculatorSquare();

			System.out.println(num + "を2倍した値は" + calculatorDouble.calculation(num) + "です");
			System.out.println(num + "を2乗した値は" + calculatorSquare.calculation(num) + "です");
		}
		 catch (NumberFormatException e) {
			throw new IllegalArgumentException("1つの数値を入力して下さい");

		}
	}

}