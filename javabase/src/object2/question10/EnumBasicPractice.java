package object2.question10;

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

		for (Season s : seasons) {
			switch (s) {
			case SUMMER:
				System.out.println(s + "は暑い！！");
				break;
			case WINTER:
				System.out.println(s + "は寒い！！");
				break;
			case SPRING:
			case FALL:
				System.out.println(s);
				break;
			default:
				throw new RuntimeException("Ileagal Season!");
			}
		}
	}
}
