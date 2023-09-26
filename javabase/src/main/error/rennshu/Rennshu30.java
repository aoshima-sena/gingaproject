package main.error.rennshu;

public class Rennshu30 {

	public static void main(String[] args) {
		try {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			System.out.println(x + y);
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("引数の数が足りません");
		} catch (NumberFormatException e) {
			System.out.println("引数はそれぞれ数値でなければいけません");
		}

	}

}
