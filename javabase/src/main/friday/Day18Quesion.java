package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day18Quesion {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("配列の長さを指定してください");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int number = Integer.parseInt(num);

		try {
			if (number <= 1) {
				System.out.println("2以上の整数を入力してください");
			}
			try {
				System.out.println("長さ分の整数を入力してください");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

				List<Integer> list = new ArrayList<Integer>();

				for (int i = 0; i < number; i++) {

					String num2 = br2.readLine();
					list.add(Integer.parseInt(num2));

				}
				/**
						int[] setArray = new int[number];
						int index = 0;
						for(int i = 0;i<number;i++) {
							boolean flag = true;
							for(int j = 0;j<number;i++) {
								if(number[i]==number[j])
							}
						}
				**/
				System.out.println("重複した値を削除すると");
				for (int i = 0; i < list.size(); i++) {

					System.out.println(list.get(i) + ",");

				}
				System.out.println("です");

			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("整数を入力してください");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("整数を入力してください");
		}

	}

}
