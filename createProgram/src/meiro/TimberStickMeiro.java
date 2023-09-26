package meiro;

import java.util.Random;

public class TimberStickMeiro {
	private static final int length = 30;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[][] meiro = new int[length + 1][length + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				//meiro[i][j] =1;
				if (j == length) {
					meiro[i][j] = 1;
				} else if (i == 0 || i == length || j == 0 || j == length) {
					meiro[i][j] = 1;
				} else if (i % 2 != 0 || j % 2 != 0) {
					meiro[i][j] = 0;
				} else {
					meiro[i][j] = 1;
				}
			}
		}
//ダイクストラ
		for (int i = 2; i <= length - 2; i = i + 2) {
			for (int j = 2; j <= length - 2; j = j + 2) {
				//	System.out.println(i + " " + j);
				//もしランダムで数字が決まったらその場所に1を入れる
				Random r = new Random();
				int num = r.nextInt(4);
				//System.out.println(num);

				if (num == 0) {
					if (meiro[i + 1][j] != 1) {
						meiro[i + 1][j] = 1;
					} else {
						meiro[i- 1][j ] = 1;
					}
				} else if (num == 1) {
					if (meiro[i - 1][j] != 1) {
						meiro[i - 1][j] = 1;
					} else {
						meiro[i + 1][j] = 1;
					}

				} else if (num == 2) {
					if (meiro[i][j + 1] != 1) {
						meiro[i][j + 1] = 1;
					} else {
						meiro[i ][j- 1] = 1;
					}

				} else if (num == 3) {
					if (meiro[i][j - 1] != 1) {
						meiro[i][j - 1] = 1;
					} else {
						meiro[i ][j+ 1] = 1;
					}

				}

			}
		}

		//真ん中の■の値はそれぞれ[2][2],[2][4]～,[4][2],[4][4]～って感じ
		//[2][2]の外に倒した場合の候補地は[2][1],[2][3],[1][2],[3][2]
		//iに+1 or -1、jに+1 or -1になる

		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= length; j++) {
				if (meiro[i][j] == 1) {
					if (j == length) {
						System.out.println("■");

					} else {
						System.out.print("■");
					}
				} else {
					System.out.print("　");
				}
			}
		}

	}

}
