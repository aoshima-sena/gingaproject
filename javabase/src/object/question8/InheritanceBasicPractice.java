package object.question8;

public class InheritanceBasicPractice {
	public static void main(String[] args) {
		// 投手オブジェクトの生成
		Pitcher p = new Pitcher("山田", 99, 0.09, 2.13);
		// 投手の紹介
		p.introduce();
	}
}
