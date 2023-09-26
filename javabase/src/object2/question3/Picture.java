package object2.question3;

public class Picture {
	private String target;

	public Picture(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return target + "の画像";
	}

}
