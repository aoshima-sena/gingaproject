package leapYear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeapYearAnswer {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int year;

			System.out.println("年を入力してください");

			while(true) {
				try {
					year = Integer.parseInt(br.readLine());

					if(year < 1) {
						System.out.println("1以上の整数を入力してください");
						continue;
					}

					break;

				}catch(NumberFormatException e) {
					System.out.println("正数を入力してください");
				}
			}

			if(year%4 == 0 && ((year%100 != 0) || (year%400 == 0))) {
				System.out.println("うるう年です");
			}else {
				System.out.println("うるう年ではありません");
			}

		}catch(IOException e) {
			System.out.println("入力エラーが発生しました。");
		}
	}

}
