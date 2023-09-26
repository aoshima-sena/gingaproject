package hitBlowGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HItBlowGameAnswer {
	//以下はヒット＆ブローゲームの作成途中です。適切に編集して実行結果と同じになるようにヒット数とブロー数を求める
	//コードを追加しプログラムを作成してください。
	//
	//ヒット＆ブローゲームとはランダムで出された数字をヒット数とブロー数を頼りに推測するゲームです。
	//ヒットは入力された桁の数がランダムで決められた桁の数と一致している数 例)(ランダム) 765 (入力) 756 → ヒット数1
	//ブローは入力された桁の数がランダムで決められたある桁の数と一致している数 例)(ランダム) 765 (入力) 675 → ブロー数3
	//詳しくは「https://45mix.net/hit-and-blow-game/」を参照してください。
	//
	//----条件----
	// 入力される値はDIFFICULTYで設定されている桁数で数字が重複しない数が入力されるとしてよい
	// //ここから
	// //ここまで
	// を修正する
	//
	//	----実行結果----
	//	数字を入力してください
	//	32
	//	Hit:0, Blow:0
	//	数字を入力してください
	//	54
	//	Hit:1, Blow:0
	//	数字を入力してください
	//	76
	//	Hit:0, Blow:0
	//	数字を入力してください
	//	98
	//	Hit:0, Blow:1
	//	数字を入力してください
	//	85
	//	Hit:1, Blow:0
	//	数字を入力してください
	//	84
	//	正解！(6回目)


	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			final int DIFFICULTY = 2;//桁数
			List<String> number = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
			Collections.shuffle(number);//シャッフルで乱数を再現
			String[] answer = number.subList(0, DIFFICULTY).toArray(new String[DIFFICULTY]);//正解の数字を比較しやすいように分割して配列に保存
			String[] input;//入力してもらった値を保存する配列
			int count = 0;
			while (true) {//入力した値と答えが一致するまで繰り返す
				int hitNum = 0;//ヒット数
				int blowNum = 0;//ブロー数
				System.out.println("数字を入力してください");
				input = br.readLine().split("");
				count++;

				//ここから

				//ヒット数とブロー数を求める
				for (int i = 0; i < answer.length; i++) {
					for (int j = 0; j < answer.length; j++) {
						if ((i == j) && (input[i].equals(answer[j]))) {//桁が同じかつ同じ数ならヒット
							hitNum++;
						} else if ((i != j) && (input[i].equals(answer[j]))) {//桁が異なるかつ同じ数ならブロー
							blowNum++;
						}
					}
				}

				//ここまで

				if (Arrays.equals(input, answer)) {
					System.out.println(String.format("正解！(%d回目)", count));
					break;
				} else {
					System.out.println(String.format("Hit:%d, Blow:%d", hitNum, blowNum));
				}
			}
		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

}
