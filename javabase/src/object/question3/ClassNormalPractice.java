package object.question3;

public class ClassNormalPractice {
	public static void main(String[] args) {
		// Personクラスのオブジェクトを作成
		Person[] persons = { new Person(), new Person(), new Person() };
		// Personオブジェクトに氏名と年齢をセット
		persons[0].setData("大島", 30);
		persons[1].setData("村上", 30);
		persons[2].setData("黒沢", 32);
		// 自己紹介
		for (int i = 0; i < persons.length; i++) {
			persons[i].introduce();
		}
		System.out.println();
		// 年齢差をチェック
		persons[0].compare(persons[1]);
		persons[1].compare(persons[2]);
		persons[2].compare(persons[1]);
	}
}
