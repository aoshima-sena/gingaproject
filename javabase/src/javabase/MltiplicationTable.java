/**
 *
 */
package javabase;


public class MltiplicationTable {
	public MltiplicationTable() {

	}
public void printMultiplicationTable() {
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
