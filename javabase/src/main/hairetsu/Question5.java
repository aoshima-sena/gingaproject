package main.hairetsu;

public class Question5 {
	public static void main(String[] args) {
		int[] score = { 45, 90, 75, 60, 80 };
		int[] rank = { 1, 4, 2, 3, 0 };

		System.out.println("----- 出席番号順 -----");

		//		for (int i = 0; i < rank.length - 1; i++) {
		//			for (int j = i + 1; j < rank.length; j++) {
		//				if (rank[j] < rank[i]) {
		//					int tmp = rank[j];
		//					rank[j] = rank[i];
		//					rank[i] = tmp;
		//					//	System.out.println(tmp);
		//			}
		//			}
		//	}

		//出席番号順の表示
		//		for (int i = 0; i < rank.length; i++) {
		//			System.out.println(rank[i]);
		//	}
		for (int i = 0; i < score.length; i++) {
			//ここにプログラムを書きます

			System.out.println((i + 1) + "番 : " + score[i] + "点");
		}
		System.out.println("----- 得点順 -----");
		//得点の高い順に表示
		for (int i = 0; i < score.length; i++) {
			//ここにプログラムを書きます

			for (int j = 0; j < score.length - 1; j++) {
				for (int r = j + 1; r < score.length; r++) {
					if (score[j] < score[r]) {
						int tmp = score[j];
						score[j] = score[r];
						score[r] = tmp;
					}
				}
			}
			System.out.println((i + 1) + "番 : " + score[i] + "点");

		}
	}
}
