package main.hukushu.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu13 {

	public static void main(String[] args) throws IOException {
		CalculatorDouble cald = new CalculatorDouble();
		CalculatorSquare cals = new CalculatorSquare();
		System.out.println("1つの数値を入力して下さい");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);

		System.out.println(num + "を2倍した値は" + cald.calculation(num) + "です");
		System.out.println(num + "を2乗した値は" + cals.calculation(num) + "です");

	}
}
