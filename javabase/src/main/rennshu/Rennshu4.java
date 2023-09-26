package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu4 {

	public static void main(String[] args) throws IOException {
		//換算したい金額（円単位）と1ドル何円かを整数値で入力すると、
		//入力した金額が何ドル何セントか計算して表示するプログラムを作成せよ。
		//1セントは1/100ドルである。結果は整数値でよい（1セント未満の端数切り捨て）。

		System.out.println("好きな金額を入力して下さい");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);

		System.out.println("日本円で" + num + "円");

		//135,71

		double result = num * 1.35;

		System.out.println("ドルにすると" + Math.round(result) + "ドル");

	}

}
