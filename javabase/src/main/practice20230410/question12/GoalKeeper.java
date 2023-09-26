package main.practice20230410.question12;

public class GoalKeeper extends SoccerPlayer {
	public static String POSITION_NAME = "ゴールキーパー";

	public GoalKeeper (String name,int uniformNumber) {
		super(name,uniformNumber);

	}

	public void catchBall() {
		System.out.println(super.getName() + "はボールを手で受け止めました");
	}

	@Override
	public String getPositionName() {

		return POSITION_NAME;
	}
}
