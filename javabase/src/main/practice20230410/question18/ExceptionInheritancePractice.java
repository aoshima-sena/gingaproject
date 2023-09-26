package main.practice20230410.question18;

public class ExceptionInheritancePractice {

	public static void main(String[] args) {
		 // 部下クラスのインスタンスを生成
        Subordinate sub = new Subordinate("有吉");
        // 上司クラスのインスタンスを生成
        Boss boss = new Boss("上島", sub);
        // 上司の働くメソッドを実行
        boss.work("得意先との取引");

	}

}
