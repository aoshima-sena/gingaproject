package setumei;

public class Animal {
	//フィールド（情報）
	String name;
	int age;

	//コンストラクタ
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;

	}

	//メソッド（振る舞い）
	public void talk(String talk) {
		System.out.println(name + "は" + talk + "について話した");
	}
}
