package javabase;

public class CalculatorSquare implements Calculator {
	public CalculatorSquare() {
	}

	@Override
	public int calculation(int inoutData) {
		return inoutData * inoutData;
	}

}
