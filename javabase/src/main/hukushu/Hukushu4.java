package main.hukushu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hukushu4 {

	public static void main(String[] args) throws IOException {
		while (true) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			//str.substring(0,1)で0から1文字目を抜き出せる
			switch (str) {
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
				System.out.println("? ? ?");
				break;
			}
		}
	}

}
