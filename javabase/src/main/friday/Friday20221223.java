package main.friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Friday20221223 {

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		int crane = random.nextInt(10) + 1;
		int turtle = random.nextInt(10) + 1;

		int cranehead = 1;
		int turtlehead = 1;
		int cranefoot = 2;
		int turtlefoot = 4;

		cranehead *= crane;
		turtlehead *= turtle;
		cranefoot *= crane;
		turtlefoot *= turtle;

		System.out.println("頭の数は" + (cranehead + turtle) + ",足の数は" + (cranefoot + turtlefoot));
		//	System.out.println(crane);
		//	System.out.println(turtle);
		while (true) {
			try {
				System.out.println("鶴は何匹？");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String str = br.readLine();
				int num1 = Integer.parseInt(str);

				if (num1 == crane) {
					System.out.println("亀は何匹？");
					String str2 = br.readLine();
					int num2 = Integer.parseInt(str2);
					if (num2 == turtle) {
						System.out.println("正解");
					} else {
						System.out.println("不正解");
					}
				} else {
					System.out.println("不正解");
					System.out.println("正解は、鶴が" + crane + "羽、亀が" + turtle + "匹でした");
				}
			} catch (NumberFormatException e) {
				System.out.println("整数を入力して下さい");
			}
		}
	}
}