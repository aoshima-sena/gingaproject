package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu9 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int inputInt = Integer.parseInt(str);

		System.out.println(inputInt + "を2倍した値は" + calculationDouble(inputInt) + "です");
		System.out.println(inputInt + "を2乗した値は" + calculationSquare(inputInt) + "です");

	}

	public static int calculationSquare(int inputInt) {
		return inputInt * inputInt;
	}

	public static int calculationDouble(int inputInt) {

		return inputInt * 2;
	}

}
