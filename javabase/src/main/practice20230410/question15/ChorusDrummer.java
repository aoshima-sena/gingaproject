package main.practice20230410.question15;

public class ChorusDrummer extends Musician implements Singable, Playable {

	public ChorusDrummer(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void play() {
		System.out.println(super.getName() + "はコーラスでハモりました");
	}

	@Override
	public void sing() {
		System.out.println(super.getName() + "はドラムを演奏しました！");
	}
}
