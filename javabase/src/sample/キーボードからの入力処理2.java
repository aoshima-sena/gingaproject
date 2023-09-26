/**
 *
 */
package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class キーボードからの入力処理2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//バッファードリーダーオブジェクトのインスタンス生成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//文字列型(String)を取得する場合
		String str = br.readLine();
		System.out.println(str);


		//整数型(int)を取得する場合
		str = br.readLine();
		int no = Integer.parseInt(str);
		System.out.println(no);
	}

}
