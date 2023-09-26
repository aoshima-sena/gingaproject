package object.question7;

public class Robot {
	int id;
	String name;
	//生産されるたびに足していっていくので初期値ではなく前の数を保持していく
	static int total;

	//引数で渡ってきた文字列をロボット名に設定し、ロボット総生産数をインクリメントします。
	//ロボットIDは1からの連番を割り振りますが、ロボット総生産数の値をうまく利用してください。
	//インクリメント = １足すこと
	public Robot(String name) {
		total++;
		this.id = id;
		this.name = name;

	}

	public static int getTotal() {
		return total;
	}

	public void introduce() {
		System.out.println("ID：" + this.id + "NAME：" + this.name);
	}
}
