/**
 *
 */
package sample;

import java.util.Scanner;

public class キーボードからの入力処理1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//スキャナーオブジェクトのインスタンス生成
		Scanner scn = new Scanner(System.in);

		//文字列型(String)を取得する場合
		String str = scn.nextLine();
		System.out.println(str);


		//整数型(int)を取得する場合
		int no = scn.nextInt();
		System.out.println(no);
	}

}
