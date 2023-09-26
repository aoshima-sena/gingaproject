package object.question9;

public class InheritanceConstructorPractice {
	public static void main(String[] args) {
		// Magazineクラスのオブジェクトを生成
		Magazine magazine = new Magazine("東京Runner", 650, "上野彩");
		// 雑誌の内容紹介メソッドの呼び出し
		magazine.show();
	}
}
