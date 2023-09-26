package javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Question14 {

	public static void main(String[] args) throws IOException {
		System.out.println("整数の個数を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int number = Integer.parseInt(str);

		System.out.println("整数を個数分入力して下さい");

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < number; i++) {
			String tmp = br.readLine();
			list.add(Integer.parseInt(tmp));
		}

		int sum = 0;
		System.out.print("入力された値は ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			sum += list.get(i);
		}
		System.out.println("です ");

		System.out.println("これらの平均は" + sum / list.size() + "です ");

	}

}
