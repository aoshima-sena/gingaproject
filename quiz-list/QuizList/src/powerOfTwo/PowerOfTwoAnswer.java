package powerOfTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 整数を入力し、2を入力した値で累乗した時の1の位の値を出力するプログラムを作成してください。
// ただし不正な値が入力されたら適切なメッセージを出力し、再入力を求めるようにしてください。
// また31以上を入力した場合、解き方によっては正しい値にならない場合がありますが、その理由も一緒に考えてみてください。
// ----条件----
// 入力される値は1以上
// メインメソッドから例外が出ないようにすること

public class PowerOfTwoAnswer {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			long number;
			int rankOneValue;

			while(true) {
				try {
					number = Long.parseLong(br.readLine());
					if(number < 1) {
						System.out.println("1以上の整数を入力してください");
						continue;
					}
					break;
				}catch(NumberFormatException e) {
					System.out.println("正数を入力してください");
				}
			}

			switch((int) (number%4)) {
			case 0:
				rankOneValue = 6;
				break;
			case 1:
				rankOneValue = 2;
				break;
			case 2:
				rankOneValue = 4;
				break;
			case 3:
				rankOneValue = 8;
				break;
			default:
				throw new IllegalArgumentException("不明なエラーが発生しました");
			}

			System.out.println(String.format("2を%d乗した時の1の位の値は%dです", number, rankOneValue));

//実際に計算して求めた場合、オーバーフローで正しい値にならない
//			int value= (int) Math.pow(2, number);
//			rankOneValue = value%10;
//
//			System.out.println(String.format("2を%d乗した時の1の位の値は%dです", number, rankOneValue));
//			System.out.println(value);
		}catch(IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

}
