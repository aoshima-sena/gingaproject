package finalDigit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinalDigitAnswer {
  // 正数を入力してその数の桁の数の総和を求める。
  // 求めた総和が二桁以上の場合はその総和の桁の数の総和を求め、一桁になるまで繰り返してその数を出力するプログラムを作成してください。
  // 123456 -> 21 -> 3
  //
  // ＝＝＝＝実行結果＝＝＝＝
  // 123456789
  // 9
  //
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int number = Integer.parseInt(br.readLine());
      int sumOfDigit = 0;

      while (true) {
        while (number > 0) {
          sumOfDigit += number % 10;
          number = number / 10;
        }
        if (sumOfDigit > 10) {
          number = sumOfDigit;
          sumOfDigit = 0;
        } else {
          break;
        }
      }

      System.out.println(sumOfDigit);

    } catch (IOException e) {
      System.out.println("入力エラーが発生しました");
    }
  }

}
