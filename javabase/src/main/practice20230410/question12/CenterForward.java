package main.practice20230410.question12;

public class CenterForward extends SoccerPlayer{


	public static final String POSITION_NAME = "センターフォワード";

	public CenterForward (String name,int uniformNumber) {
		super(name,uniformNumber);

	}

	public String getPositionName() {
		return POSITION_NAME;
	}
}
