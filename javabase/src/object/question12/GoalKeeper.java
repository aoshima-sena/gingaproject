package object.question12;

public class GoalKeeper extends SoccerPlayer {
	private static final String POSITION_NAME = "ゴールキ－パー";

	public GoalKeeper(String name, int uniformNumber) {
		super(name, uniformNumber);

	}

	public String getPositionName() {
		return POSITION_NAME;
	}

	public void kickBall() {
		super.kickBall();
	}

}
