package lesson.ans;

/**
 * Java Lessonn 3
 * キーボードから入力した値を元にfor文を体験しよう
 * □部分を修正し動作を確認してください。
 * 解らない人は、解答のプログラムを見て入力してください。
 * @author yoshi
 *
 */
public class Lesson5ForAns {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		//メッセージの出力処理
		System.out.println("九九の2の段を表示します");

		for (int i = 1; i < 10; i++) {

			System.out.println("2×" + i + "=" + (2 * i));
		}

		//メッセージの出力処理
		System.out.println("処理を終了しました");

	}

}
