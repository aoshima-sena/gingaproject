package main.practice20230411.question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopyPractice {

	public static void main(String[] args) {

		/*String name = "";

		try {
			File file = new File("aaa");
			FileReader fr = new FileReader(name);
			BufferedReader bufferedReader = new BufferedReader(fr);
			System.out.println(bufferedReader.readLine());
			FileReader fileReader  = new FileReader(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			PrintWriter pw = new PrintWriter(file);
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("ファイル名の指定が不正です");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("入出力エラーです");
			e.printStackTrace();
		}*/

		BufferedReader br = null;
		PrintWriter pw = null;

		if (args.length != 2) {
			System.out.println("2つのファイル名を正しく指定してください");
			return;
		}

		try {
			//データ読み取り呼び出し
			br = new BufferedReader(new FileReader(args[0]));
			//データ書き込み呼び出し
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

			String str;

			//fileがnullになるまで処理を続ける
			while ((str = br.readLine()) != null) {
				//データコピー
				pw.println(str);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイル名の指定が不正です");
		} catch (IOException e) {
			System.out.println("入出力エラーです");
		} finally {
			try {
				//終わったら閉じる
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			//ここも閉じる
			if (pw != null) {
				pw.close();
			}
		}
	}

}
