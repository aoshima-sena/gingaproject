package lesson;

import java.util.Scanner;

/**
 * Java Lessonn　１
 * キーボードから入力した値の出力を体験しよう

 * @author yoshi
 *
 */
public class Lesson2InputMsgOutput {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		//メッセージの出力処理
		System.out.println("文字を入力しエンターキーを押してください");

		//キーボードから入力した値を操作するオブジェクトの生成
		Scanner scn = new Scanner(System.in);

		//キーボードから入力した文字を受け取る処理
		String keyStr = scn.nextLine();

		//受っとった内容を表示する処理
		System.out.println(keyStr);

	}

}
