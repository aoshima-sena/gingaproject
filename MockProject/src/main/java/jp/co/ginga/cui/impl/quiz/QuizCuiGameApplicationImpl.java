package jp.co.ginga.cui.impl.quiz;

import java.util.ArrayList;
import java.util.List;

import jp.co.ginga.cui.CuiGameApplication;
import jp.co.ginga.main.QuizQuestion;
import jp.co.ginga.util.exception.ApplicationException;
import jp.co.ginga.util.exception.SystemException;
import jp.co.ginga.util.keybord.Keybord;
import jp.co.ginga.util.properties.MessageProperties;

public class QuizCuiGameApplicationImpl implements CuiGameApplication {
	private List<QuizQuestion> list;
	private int correctCount;

	@Override
	public void action() throws SystemException {

		System.out.println(MessageProperties.getMessage("quiz.msg.start"));

		createQuizList();

		for (QuizQuestion quiz : list) {

			viewProblem(quiz);

			judge(quiz);
		}

		viewResult();

		System.out.println(MessageProperties.getMessage("quiz.msg.end"));
	}

	private void createQuizList() throws SystemException {
		try {
			list = new ArrayList<QuizQuestion>();
			String qmq = MessageProperties.getMessage("quiz.number.questions");
			int num = Integer.parseInt(qmq);
			for (int i = 1; i <= num; i++) {
				String t = MessageProperties.getMessage("quiz.question.title" + i);
				String b = MessageProperties.getMessage("quiz.question.body" + i);
				String ch = MessageProperties.getMessage("quiz.question.choice" + i);
				String c = MessageProperties.getMessage("quiz.question.correct" + i);
				int correct = Integer.parseInt(c);
				QuizQuestion quizQuestion = new QuizQuestion(t, b, ch, correct);
				this.list.add(quizQuestion);
			}
		} catch (NumberFormatException e) {

			System.out.println(MessageProperties.getMessage("error.non.number"));
		}

	}

	private void viewProblem(QuizQuestion quiz) {

		System.out.println(quiz.getProblemTitle());

		System.out.println(quiz.getProblemBody());

		System.out.println(quiz.getProblemChoice());

	}

	private void judge(QuizQuestion quiz) throws SystemException {

		while (true) {
			try {

				System.out.println(MessageProperties.getMessage("quiz.msg.input"));

				int m = Keybord.getInt(1, 3);

				int gc = quiz.getCorrect();

				if (m == gc) {
					correctCount = correctCount + 1;

				}
				break;
			} catch (ApplicationException e) {

				System.out.println(MessageProperties.getMessage("msg.retype"));
			}
		}
	}

	private void viewResult() throws SystemException {

		//System.out.println((MessageProperties.getMessage("quiz.msg.correct" + correctCount));
		if (correctCount == 0) {

			System.out.println(MessageProperties.getMessage("quiz.msg.correct0"));
		} else if (correctCount == 1) {

			System.out.println(MessageProperties.getMessage("quiz.msg.correct1"));
		} else if (correctCount == 2) {

			System.out.println(MessageProperties.getMessage("quiz.msg.correct2"));
		} else if (correctCount == 3) {

			System.out.println(MessageProperties.getMessage("quiz.msg.correct3"));
		} else {

			System.out.println(MessageProperties.getMessage("error.keybord"));
		}
	}

}
