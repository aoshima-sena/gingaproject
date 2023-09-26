package lesson.ans;

import java.util.Scanner;

/**
 * Java Lessonn 4
 * キーボードから入力した値を元にswitch文を体験しよう
 * □部分を修正し動作を確認してください。
 * 解らない人は、回答ようのプログラムを見て入力してください。
 * @author yoshi
 *
 */
public class Lesson4SwitchAns {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			//メッセージの出力処理
			System.out.println("1-3の値を入力してください");
			System.out.println("数値以外の値を入力した場合も試してみてください");

			//キーボードから入力した値を操作するオブジェクトの生成
			Scanner scn = new Scanner(System.in);

			//キーボードから入力した文字を受け取る処理
			int keyNo = scn.nextInt();

			//□の箇所に、評価する値を入力してください。
			switch(keyNo) {
			case 1:
				System.out.println("1が入力されました");
				break;
			case 2:
				System.out.println("2が入力されました");
				break;
			case 3:
				System.out.println("3が入力されました");
				break;
			default:
				System.out.println("1-3以外が入力されました");
				break;
			}

		}catch(Exception e) {
			System.out.println("数値以外が入力されました。");
		}

		System.out.println("処理を終了しました");

	}

}
