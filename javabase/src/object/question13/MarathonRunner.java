package object.question13;

public class MarathonRunner extends Athlete {

	public static final String TYPE = "マラソン";

	public MarathonRunner(String name) {
		this.name = name;
	}

	public String getType() {
		return TYPE;
	}

	public void run() {
		System.out.println(this.name + "は走りました。");
	}

}
