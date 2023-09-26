package main.rennshu16;

public class MultipleChoiceQuiz extends Quiz {

	String[] answer;

	public MultipleChoiceQuiz(String main, String[] answer) {
		super(main);
		this.answer = answer;
	}

	//@Override
	public void displayHeader() {
		System.out.println("次の問いについて、正しいものを4つの中から選びなさい");
	}

	//@Override
	public void displayMain() {
		super.displayMain();
		for (int i = 0; i < answer.length; i++) {
			System.out.println((1 + i) + ":" + answer[i]);
		}

	}

}
