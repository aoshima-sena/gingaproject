package main.rennshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rennshu5 {

	public static void main(String[] args) throws IOException {
		//初乗り料金が1700mまで610円、それ以降は313mごとに80円のタクシーがある。
		//このタクシーに乗った距離をm単位で入力し、料金を計算するプログラムを作成せよ。
		System.out.println("何メートル走りましたか？");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int distance = Integer.parseInt(str);

		int result1 = distance - 1700;

		//距離-1700/313*80 + 610
		System.out.println("料金は" + ((result1 / 313) * 80 + 610) + "円です");
	}

}
