package main.hairetsu;

public class Question3 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 6, 7, 8, 9, 10 };
		int[] c = new int[5];

		//ここにプログラムを書きます
		for (int i = 0; i < a.length; i++) {

			c[i] = a[i] + b[i];

		}
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}
}
