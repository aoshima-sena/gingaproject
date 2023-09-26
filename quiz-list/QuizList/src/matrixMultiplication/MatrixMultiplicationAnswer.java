package matrixMultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiplicationAnswer {
	/*
	 * 3x3行列の積を計算するプログラムを作成してください。
	 * 行列の積とは以下のように計算する
	 *
	 * 		|a11, a12, a13|			|b11, b12, b13|
	 * A=|a21, a22, a23|		B=|b21, b22, b23|	  のとき
	 * 		|a31, a32, a33|			|b31, b32, b33|
	 *
	 *          |a11xb11 + a12xb21 + a13xb31, a11xb12 + a12xb22 + a13xb32, a11xb13 + a12xb23 + a13xb33|
	 *AxB = |a21xb11 + a22xb21 + a23xb31, a21xb12 + a22xb22 + a23xb32, a21xb13 + a22xb23 + a23xb33|
	 *			 |a31xb11 + a32xb21 + a33xb31, a31xb12 + a32xb22 + a33xb32, a31xb13 + a32xb23 + a33xb33|
	 *
	 * 条件
	 * 整数が来ることを前提にしてよい
	 * 入力メソッドは以下をconvertCSVtoArrayを使用する
	 * 配列の出力メソッドはprintArrayメソッドを使用する
	 * 入力は以下をコピーして貼り付ける(CSV)
	 *
	---入力1---
	1,1,1
	1,1,1
	1,1,1
	1,2,3
	2,1,2
	3,2,1

	---出力1---
	6 5 6
	6 5 6
	6 5 6


	---入力2---
	1,2,3
	4,5,6
	7,8,9
	9,8,7
	6,5,4
	3,2,1

	---出力2---
	30 24 18
	84 69 54
	138 114 90

	---入力3---
	1,3,5
	7,11,13
	17,19,23
	1,2,4
	8,16,32
	64,128,256

	---出力3---
	345 690 1380
	927 1854 3708
	1641 3282 6564

	 */

	public static int ROW_NUMBER = 3;
	public static int COLUMN_NUMBER = 3;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int[][] leftArray;
		int[][] rightArray;
		int[][] answerArray;

		try {
			leftArray = convertCSVtoArray();
			rightArray = convertCSVtoArray();
			answerArray = new int[ROW_NUMBER][COLUMN_NUMBER];

			for (int i = 0; i < ROW_NUMBER; i++) {
				for (int j = 0; j < COLUMN_NUMBER; j++) {
					int value = 0;
					for (int k = 0; k < COLUMN_NUMBER; k++) {
						value += leftArray[i][k] * rightArray[k][j];
					}
					answerArray[i][j] = value;
				}
			}

			printArray(answerArray);

		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

	public static int[][] convertCSVtoArray() throws IOException {
		int[][] array = new int[ROW_NUMBER][COLUMN_NUMBER];
		for (int i = 0; i < array.length; i++) {
			String[] inputLine = br.readLine().split(",");
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = Integer.parseInt(inputLine[j]);
			}
		}
		return array;
	}

	public static void printArray(int[][] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
