package main.rennshu16;

public class BlankQuiz extends Quiz {

	int blankCount;

	public BlankQuiz(String main, int blackCount) {
		super(main);
		this.blankCount = blackCount;

	}

	public void displayHeader() {
		System.out.println("「次の文の空欄を埋めなさい。」");
	}

	public void displayMain() {
		super.displayMain();
		for (int i = 0; i < blankCount; i++) {
			System.out.println((i + 1) + ".___________");

		}
	}

}
