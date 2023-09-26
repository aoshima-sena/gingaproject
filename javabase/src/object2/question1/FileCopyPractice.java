package object2.question1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopyPractice {
	public static void main(String[] args) {

		BufferedReader br = null;
		PrintWriter pw = null;

		//コマンドラインが不正に渡されたときに実行
		if (args.length != 2) {
			System.out.println("2つのファイル名を正しく指定してください");
			return;
		}

		try {
			br = new BufferedReader(new FileReader(args[0]));

			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

			String str;
			//nullが返ってくるまでデータを取得し続ける
			while ((str = br.readLine()) != null) {

				pw.println(str);
			}

		} catch (FileNotFoundException e) {
			System.out.println("ファイル名の指定が不正です");
		} catch (IOException e) {
			System.out.println("入出力エラーです");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (pw != null) {
				pw.close();
			}
		}

	}
}
