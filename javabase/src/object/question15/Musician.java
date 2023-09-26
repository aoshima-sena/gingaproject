package object.question15;

public abstract class Musician {
	// 名前フィールド
	private String name;

	// コンストラクタ
	public Musician(String name) {
		this.name = name;
	}

	// 名前取得メソッド
	public String getName() {
		return name;
	}
}
