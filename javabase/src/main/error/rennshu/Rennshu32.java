package main.error.rennshu;

public class Rennshu32 {

	public static void main(String[] args) {
		try {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			warizan(x, y);
		} catch (ArithmeticException e) {
			System.out.println("割る数が0になっています");
		} catch (Exception e) {
			System.out.println("引数は2つの数値を指定してください");
		}
	}

	public static void warizan(int x, int y) throws ArithmeticException {

		System.out.println(x / y);

	}

}
