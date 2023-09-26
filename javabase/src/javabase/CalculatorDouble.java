package javabase;

public class CalculatorDouble implements Calculator {
	public CalculatorDouble() {

	}

	@Override
	public int calculation(int inputData) {
		return inputData * 2;
	}
}
