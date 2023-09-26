package caesarChiper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarChiper {

	/*
	 * 以下のプログラムはアルファベットからなる文字列を入力し、シーザー暗号で暗号化と復号化を行い表示するプログラムの作成途中です。
	 * 実行結果と同じになるようにコードを追加し、プログラムを完成させてください。
	 *
	 * ----ヒント----
	 * javaのchar型とint型には互換性があります。文字をシングルクォーテーションで囲うとchar型になります。
	 * char型をint型に変換した際はAは65、Bは66、Xは89、Zは90、aは97、bは98、xは121、zは122を表します。
	 * Stringをまずcharに変換し、大文字か小文字かで分岐させ、charをint型に変換し、適切に演算させてからintを文字列に変換してからStringBilderに追加してみてください。
	 *
	 * StringからChar型に変換するには文字列のインスタンスからcharAt(0)を呼び出すことで可能です。
	 * charからint型に変換する方法は直接int型の変数にchar型を代入することで可能です。
	 * 大文字か小文字化の判断はCharacterクラスのisUpperCaseメソッドを使用することで可能です。
	 * int型からそれに対応する文字列に変換するにはCharacterクラスのtoStringメソッドを使用することで可能です。
	 *
	 *
	 * シーザー暗号とは、文字を一つずつずらしていく暗号化方法です。
	 * 暗号化の場合aならb、fならg、zならaとなるように、復号化の場合bならa、gならf、aならzのようにずらします。
	 * 暗号化例）入力 z a b c d
	 * 						 ＼＼＼＼＼
	 * 	  			出力 		 a b c d e
	 *
	 * 復号化例）入力 z a b c d
	 * 						＼＼＼＼＼
	 * 				出力		x z a b c
	 *
	 * ----条件----
	 * 修正する箇所は
	 * //ここから
	 * //ここまで
	 * のところを修正する。
	 * 入力される文字列は大文字小文字のアルファベットのみ入力されるとしてよい
	 *
	 */

	public static final int CODE_UPPER_A = 'A';
	public static final int CODE_UPPER_Z = 'Z';
	public static final int CODE_LOWWER_A = 'a';
	public static final int CODE_LOWWER_Z = 'z';

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String str = br.readLine();
			String encodeStr = encode(str);
			String decodeStr = decode(encodeStr);
			System.out.println("入力した文字列は" + str);
			System.out.println("エンコードした文字列は" + encodeStr);
			System.out.println("デコードした文字列は" + decodeStr);

		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

	public static String encode(String str) {
		String[] list = str.split("");//アルファベットごとに分割する
		StringBuilder encodeSb = new StringBuilder();

		//ここから

		return  "Hello world";
		//ここまで


	}

	public static String decode(String str) {
		String[] list = str.split("");//アルファベットごとに分割する
		StringBuilder decodeSb = new StringBuilder();

		for (String strAlpha : list) {
			char charAlpha = strAlpha.charAt(0); //文字列からchar型に変換
			int intAlpha = charAlpha; //char型からint型に変換

			if (Character.isUpperCase(charAlpha)) {//大文字なら
				intAlpha = ((intAlpha == CODE_UPPER_A) ? CODE_UPPER_Z : intAlpha - 1);//AならZの文字コード、それ以外は現在の文字コードから1を引いたものを代入
			} else {//小文字なら
				intAlpha = ((intAlpha == CODE_LOWWER_A) ? CODE_LOWWER_Z : intAlpha - 1);//aならzの文字コード、それ以外は現在の文字コードから1を引いたものを代入
			}

			String convertString = Character.toString(intAlpha);//int型を対応する文字列に変換
			decodeSb.append(convertString);//連結
		}

		return decodeSb.toString();
	}

}
