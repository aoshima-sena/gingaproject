package setProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetProblemAnswer {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			//回数入力
			System.out.println("配列の長さを指定して下さい");
			int length = getInt(2);
			//回数分入力
			System.out.println("長さ分の正数を入力してください");
			int[] array = new int[length];
			for (int i = 0; i < length; i++) {
					array[i] = getInt(1);
			}

			//重複したものを1個だけにする処理
			int[] setArray = new int[length];
			int index = 0;
			for (int i = 0; i < array.length; i++) {
				boolean flag = true;
				for (int j = 0; j < setArray.length; j++) {
					if (array[i] == setArray[j]) {
						flag = false;
						break;
					} else if (setArray[j] == 0) {
						break;
					}
				}
				//追加、加算処理
				if (flag) {
					setArray[index] = array[i];
					index++;
				}
			}
			//出力処理
			System.out.print("重複した値を削除すると ");
			for (int number : setArray) {
				if (number == 0) {
					break;
				}
				System.out.print(number + ", ");
			}
			System.out.println("です");

		} catch (IOException e) {
			System.out.println("入力エラーが発生しました");
		}
	}

	private static int getInt(int from) throws IOException{
		while (true) {
			try {
				int number = Integer.parseInt(br.readLine());
				if (number < from) {
					System.out.println(String.format("%d以上の整数を入力して下さい", from));
					continue;
				}
				return number;
			} catch (NumberFormatException e) {
				System.out.println("正数を入力してください");
			}
		}
	}
}
