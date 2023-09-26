package object.question18;

public abstract class Employee {
	// 社員名
	protected String name;

	// 働く抽象メソッド
	public abstract void work(String workName) throws TroubleException;
}
