package main.Tameshini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tameshini {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

	//	Scanner scan = new Scanner(System.in);
		//String num = scan.next();
	//	int num = scan.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num2 =Integer.valueOf(str);
		String str2 = br.readLine();
		int num3 = Integer.parseInt(str2);

	//	System.out.println(num + "です");
	//System.out.println(num2 + "です");


		if(num2 == num3) {
			System.out.println("同じ");

		}else {
			System.out.println("違う");
		}
		//Scannerだと大文字数字で表記されていた。
		//ScannerだとintだろうがStringだろうが関係なく表記できるから大文字のまま表記される
		//BufferedReaderは基本データ型しか受け付けず、途中で参照型の変換をするから
		//その変換の途中で小文字の数字に代わる
	}

}
