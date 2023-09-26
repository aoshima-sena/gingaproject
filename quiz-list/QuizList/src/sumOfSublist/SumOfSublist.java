package sumOfSublist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SumOfSublist {

  // 以下のクラスは数が追加されているリストから入力で指定した範囲の要素の総和と、その総和の桁の数の総和を求め出力するプログラムの作成途中です。
  // 以下のクラスをダウンロードしてコードを記述し入力で指定した範囲の要素の総和と、その総和の桁の数の総和を求め出力できるようにしてください。
  //
  // ＝＝＝＝条件＝＝＝＝
  // 入力メソッドは同クラスのgetIntを使用して下さい
  // 範囲を入力する際に左側のインデックスが右側のインデックス以上の場合は適切なメッセージを表示し再入力を求めるようにして下さい
  // 総和はsum変数、桁の数の総和はsumDigit変数、左側のインデックスはfrom変数、右側のインデックスはto変数を使用してください。

  public static void main(String[] args) {
    try {
      // int min;
      // int max;
      // int step;
      // int count;
      //
      // // 入力
      // while (true) {
      // min = getInt("min=");
      // max = getInt("max=");
      // if (min < max) {
      // break;
      // }
      // System.out.println("maxはminより大きい値を入力してください");
      // }
      // step = getInt("step=");
      // count = getInt("count=");

      // リスト生成
      List<Integer> numberList = generateSequence(10, 100, 3, 20);
      int from; // 左範囲インデックス
      int to;// 右範囲インデックス
      int sum = 0; // 総和用
      int digitSum = 0;// 総和の桁の数の総和用

      // ここから

      // ここまで

      // 出力
      System.out.println(String.format("範囲の要素の総和は%dで桁の数の総和は%dです", sum, digitSum));

    } catch (IOException e) {
      System.out.println("入力エラーが発生しました");
    }

  }

  /**
   * 正数を入力させる取得する
   *
   * @param String 入力時に表示する内容
   * @return int
   * @throws {@link IOException}
   */
  public static int getInt(String... params) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      try {
        if (params.length == 1) {
          System.out.print(params[0]);
        }
        int value = Integer.parseInt(br.readLine());
        if (value < 1) {
          throw new NumberFormatException();
        }
        return value;
      } catch (NumberFormatException e) {
        System.out.println("正数を入力してください");
      }
    }
  }

  /**
   * 最小値から最大値まで増加分ずつ増やした個数分のリストを作成
   *
   * @param int 最小値
   * @param int 最大値
   * @param int 増加分
   * @param int 個数
   * @return {@link List} <{@link Integer}>
   */
  public static List<Integer> generateSequence(int min, int max, int step, int number) {

    // 数を保存するリスト
    List<Integer> sequence = new ArrayList<Integer>();

    // valueをminからstepずつ増やしmaxまでsequenceに追加
    for (int value = min; value <= max; value += step) {
      sequence.add(value);
    }

    return sequence;
  }
}
