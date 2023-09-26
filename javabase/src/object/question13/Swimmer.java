package object.question13;

public class Swimmer extends Athlete {
	public static final String TYPE = "水泳";

	public Swimmer(String name) {
		this.name = name;
	}

	public String getType() {
		return TYPE;
	}

	public void swim() {
		System.out.println(this.name + "は泳ぎました。");
	}
}
