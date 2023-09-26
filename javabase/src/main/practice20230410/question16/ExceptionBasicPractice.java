package main.practice20230410.question16;

public class ExceptionBasicPractice {

	public static void main(String[] args) {

		try {
		// 分子変数
        int numerator = 4200;
        // 分母変数
        int denominator=0;
        // コマンドライン引数を整数値に変換する
        denominator = Integer.parseInt(args[0]);
        // 割り算結果変数に代入
        int result = numerator / denominator;
        System.out.println("割り算の結果は" + result + "です");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("コマンドライン引数を指定してください");
		}catch(NumberFormatException e ) {
			System.out.println("コマンドライン引数には整数を指定してください");
		}catch(ArithmeticException e) {
			System.out.println("コマンドライン引数には0以外の整数を指定してください");
		}
		System.out.println("プログラムを終了します");

	}

}
