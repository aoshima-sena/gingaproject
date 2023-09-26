package main.practice20230410.question12;

 abstract class SoccerPlayer {

	private String name;
	private int uniformNumber;

	public  SoccerPlayer(String name, int uniformNumber) {
		this.name = name;
		this.uniformNumber = uniformNumber;
	}

	public String getName() {
		return this.name ;
	}

	public void  kickBall() {
		System.out.println(this.name +"はボールを蹴りました");
	}

	public void catchBall() {
		System.out.println(this.name + "はボールを足で受け止めました");

	}

	public abstract String getPositionName() ;

	public String toString() {
	return getPositionName() + " " + this.name + "背番号"+this.uniformNumber;
}
}