package main.practice20230411.question3;

public class Picture {

	String target;

	public Picture(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return target + "の画像";
	}
}
