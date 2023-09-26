package javabase;

/**
 *
 */

import java.io.IOException;

/**
 * @author souken
 *
 */
public class Question5 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 9) {
					System.out.println(i + "×" + j + "＝" + i * j);
				} else {
					System.out.print(i + "×" + j + "＝" + i * j);
					if (i * j < 10) {
						System.out.print("    ");
					} else {
						System.out.print("   ");
					}
				}
			}
		}
	}

}
