package main.hairetsu;

public class Question4 {
	public static void main(String[] args) {
		int[][] array = {
				{ 1, 8, 12, 17, 20 },
				{ 2, 5, 11, 13, 18 },
				{ 4, 6, 9, 19, 21 }
		};
		//ここからプログラムを書いていきます。
		int onesize = array[0].length;
		int tatesize = array.length;
		for (int i = 0; i < tatesize; i++) {
			for (int j = 0; j < onesize; j++) {
				if (j < 4) {
					System.out.print(array[i][j] + " ");
				} else if (j == 4) {
					System.out.print(array[i][j] + " ");
					System.out.println();
				}

				//for文抜けた後に改行でもよかった
			}
		}
	}
}
