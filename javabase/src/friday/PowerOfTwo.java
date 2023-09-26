package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfTwo {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);
		int two = 2;
		int result =1;

		for(int i=1;i<=num;i++) {
			result = result*two;
		}



		System.out.println("2を"+num+"乗した数の1の位の値は"+sum(result)+"です");

	}

	public static int sum(int result) {
		int num=0;
		while(num==0) {
			num=result%10;
			result/=10;
		}

		return num;
	}

}
