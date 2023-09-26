package main.practice20230410.question15;

public class Guitarist extends Musician implements Playable {
	String guitarType;



	public Guitarist(String name, String guitarType) {
		super(name);
		this.guitarType = guitarType;
	}

	@Override
	public void play() {
		System.out.println(super.getName() + "は" + this.guitarType + "を演奏しました！");
	}

}
