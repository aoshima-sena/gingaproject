package lesson.ans;

import java.util.Scanner;

/**
 * Java Lessonn 3
 * キーボードから入力した値を元にif文を体験しよう

 * @author yoshi
 *
 */
public class Lesson3IfAns{

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

			if(keyNo == 1) {
				System.out.println("1が入力されました");
			}else if(keyNo == 2) {
				System.out.println("2が入力されました");
			}else if(keyNo == 3) {
				System.out.println("3が入力されました");
			}else {
				System.out.println("1-3以外が入力されました");
			}

		}catch(Exception e) {
			System.out.println("数値以外が入力されました。");
		}

		System.out.println("処理を終了しました");

	}

}
