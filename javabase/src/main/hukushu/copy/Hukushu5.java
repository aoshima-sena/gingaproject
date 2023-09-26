package main.hukushu.copy;

public class Hukushu5 {

	public static void main(String[] args) {

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + "×" + j + "=" + (i * j) + " ");
				if (i * j < 10) {
					System.out.print("   ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
