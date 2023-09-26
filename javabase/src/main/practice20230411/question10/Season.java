package main.practice20230411.question10;

public enum Season {

	SPRING("春"), SUMMER("夏"), FALL("秋"), WINTER("冬");

	private String name;

	Season(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
