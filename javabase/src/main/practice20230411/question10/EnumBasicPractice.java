package main.practice20230411.question10;

public class EnumBasicPractice {

	public static void main(String[] args) {

		// 四季列挙子を格納した配列変数の宣言
		Season[] seasons = {
				Season.SPRING,
				Season.SUMMER,
				Season.FALL,
				Season.WINTER
		};
		// 四季をループで回す

		for (Season season : seasons) {
			/*if (season.toString().equals("夏")) {
				System.out.println(season.toString() + "は暑い！！");
			} else if (season.toString().equals("冬")) {
				System.out.println(season.toString() + "は寒い！！");
			} else {
				System.out.println(season.toString());
			}*/

			switch (season) {
			case SUMMER:
				System.out.println(season.toString() + "は暑い！！");
				break;
			case WINTER:
				System.out.println(season.toString() + "は寒い！！");
				break;
			default:
				System.out.println(season.toString());
				break;

			}
		}
	}

}
