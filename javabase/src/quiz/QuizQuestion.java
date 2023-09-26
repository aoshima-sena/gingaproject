package quiz;

public class QuizQuestion {
	private String problemTitle;
	private String problemBody;
	private String problemChoice;
	private int correct;

public  QuizQuestion(String problemTitle,String problemBody,String problemChoice,int correct) {

	this.problemTitle=problemTitle;
	this.problemBody=problemBody;
	this.problemChoice=problemChoice;
	this.correct=correct;


}

public String getProblemTitle() {
	return problemTitle;
}

public void setProblemTitle(String problemTitle) {
	this.problemTitle=problemTitle;
}

public String getProblemBody() {
	return this.problemBody;
}

public void setProblemBody(String problemBody) {
	this.problemBody=problemBody;
}

public String getProblemChoice() {
	return this.problemChoice;
}

public void setProblemChoice(String priblemChice) {
	this.problemChoice=problemChoice;
}

public int getCorrect() {
	return this.correct;
}

public void setCorrect(int correct) {
	this.correct=correct;
}
}
