package object.question12;

public class CenterForward extends SoccerPlayer {
	//static finalをつけると値が変更されなくていい
	private static final String POSITION_NAME = "センターフォワード";

	public CenterForward(String name, int uniformNumber) {
		super(name, uniformNumber);

	}

	public String getPositionName() {
		return POSITION_NAME;
	}

	public void catchBall() {
		super.catchBall();
	}

}
