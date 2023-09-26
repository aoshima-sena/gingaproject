package object.question13;

public abstract class Athlete {
	// 選手名
	protected String name;

	// 種目名取得メソッド（抽象メソッド）
	public abstract String getType();

	@Override
	public String toString() {
		return "私の名前は" + name + "、" + getType() + "の選手です。";
	}
}
