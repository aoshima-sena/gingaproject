package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Frinday20230407 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num1 = Integer.parseInt(str);

		System.out.println("入力された数は" + num1 + "です。");

		String number = String.valueOf(num1);
		/*char[] hairetsu = number.toCharArray();
		int val = contains(hairetsu);*/
		int length = number.length();
		System.out.println(length);

		int correct = 0;

		for(int i=0;i<length ; i++) {

		}


		System.out.println(correct);

	}



}
