package quiz;

import java.util.List;

import properties.MessageProperties;

public class QuizCuiGameApplicationlmpl {
	private List<QuizQuestion> list;
	private int correctCourt;

	public QuizCuiGameApplicationlmpl() {

	}

	public void action() {
		System.out.println(MessageProperties.getMessage);
		createQuizList();
	}



	private void createQuizList() {
		System.out.println("問題1" + " " + ":" + "  " + "昭和40年頃の理髪店の料金はいくらだったでしょうか？");
		System.out.println("問題2" + " " + ":" + "  " + "昭和40年代、コカ・コーラの瓶をお店に返すと「ある物」が貰えました。それは一体何でしょうか？");
		System.out.println("問題3" + " " + ":" + "  " + "1967年(昭和42年)、日本で初めて動く歩道が誕生しました。それはどこでしょうか？");
	}

	private void viewProblem(QuizQuestion quiz) {
		quiz.setProblemTitle("選択肢" + " " + ";" + "  " + "1.560円" + "2.350円" + "3.1000円");
	}



	private void viewResult() {

	}
}
