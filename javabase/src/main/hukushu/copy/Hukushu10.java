package main.hukushu.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		if (str1.equals(str2)) {
			System.out.println(str1 + "と" + str2 + "は同じ値です");

		} else {
			System.out.println(str1 + "と" + str2 + "は異なる値です");
		}
	}
}
