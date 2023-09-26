package main.rennshu16;

public class Quiz {

	//問題文
	private String main;

	public Quiz(String main) {
		this.main = main;
	}

	public void displayHeader() {
		System.out.println("「次の問いに答えなさい」");
	}

	//mainの内容表示
	public void displayMain() {
		System.out.println(main);
	}
}
