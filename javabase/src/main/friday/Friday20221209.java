package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Friday20221209 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		int result = 0;
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String num = br.readLine();
			int number = Integer.parseInt(num);

			List<Integer> list = new ArrayList<Integer>();

			//	String result = String.valueOf(number);

			//	char[] digits1 = result.toCharArray();

			//	int one = number/10;
			//		list.add(one);
			//	int ten = number/100;

			//	for (int i = 0; i < number; i++) {
			//		number = (int) (number / Math.pow(10, i));
			//		String num2 = br.readLine();
			//		list.add(Integer.parseInt(num2));

			//	}

			//	System.out.println(number);
			//		list.add(number);
			//		for (int j = 0; j < list.size(); j++) {
			//		number = (int) (number / Math.pow(10, j));
			//			//	number = list.get(j);
			//			number = number * j + number * (j + 1);

			//	}

			while (number > 0) {
				result += number % 10;
				number /= 10;
			}

			System.out.println(result);
		} catch (Exception e) {
			throw new IllegalArgumentException("整数を入力してください");
		}

	}

}
