package object.question15;

public class Guitarist extends Musician implements Playable {

	private String guitarType;

	public Guitarist(String name, String guitarType) {
		super(name);
		this.guitarType = guitarType;

	}

	public void play() {
		System.out.println(getName() + "は" + this.guitarType + "を演奏しました！");
	}

}
