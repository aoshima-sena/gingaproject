package object.question12;

public abstract class SoccerPlayer {

	private String name;
	private int uniformNumber;

	public SoccerPlayer(String name, int uniformNumber) {
		this.name = name;
		this.uniformNumber = uniformNumber;

	}

	public String getName() {
		return this.name;
	}

	public void kickBall() {
		System.out.println(this.name + "はボールを蹴りました");
	}

	public void catchBall() {
		System.out.println(this.name + "はボールを足で受け止めました");
	}

	//それぞれのポジション名を取得する抽象メソッド
	public abstract String getPositionName();

	@Override
	public String toString() {
		return getPositionName() + " " + name + "背番号" + uniformNumber;
	}
}
