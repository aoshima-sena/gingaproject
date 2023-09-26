package lesson;

/**
 * Java Lessonn 3
 * キーボードから入力した値を元に配列を体験しよう
 * □部分を修正し動作を確認してください。
 * 解らない人は、解答のプログラムを見て入力してください。
 * @author yoshi
 *
 */
public class Lesson6Array {

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		//メッセージの出力処理
		System.out.println("配列を利用したプログラムです。");

		int[] array = new int[5];

		array[1] = 100;
		array[2] = 200;
		array[3] = 300;
		array[4] = 400;
		array[5] = 500;

		//□の箇所に、評価する値を入力してください。
		for (int i = 0; i < array.length; i++) {

			System.out.println("array[" + i + "]の値は" + array[i] + "です");
		}

		//メッセージの出力処理

		System.out.println("配列を利用しない場合のプログラムです。");
		//以下に配列を使用しない場合のプログラムを記述します。
		//同じ表示結果を出すことはできますが、記述量に違いがあることを認識してください。
		//配列の数が５ではなく1000になったとしたら、どちらの記述を選択しますか？

		int no1 = 100;
		int no2 = 200;
		int no3 = 300;
		int no4 = 400;
		int no5 = 500;

		System.out.println("no1の値は" + no1 + "です");
		System.out.println("no2の値は" + no2 + "です");
		System.out.println("no3の値は" + no3 + "です");
		System.out.println("no4の値は" + no4 + "です");
		System.out.println("no5の値は" + no5 + "です");

		//メッセージの出力処理
		System.out.println("処理を終了しました");

	}

}
