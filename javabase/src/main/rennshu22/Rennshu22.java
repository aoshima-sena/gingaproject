package main.rennshu22;

public class Rennshu22 {

	public static void main(String[] args) {
		Message msg1 = new Message("今日はいい天気。散歩でも行こうかな、中野ブロードウェイまで♡");
		msg1.setReaction(new Reaction("(^ ^)", 3));
		msg1.setReaction(new Reaction("(^o^)d", 2));
		msg1.setReaction(new Reaction("(- -;)", 0));

		Message msg2 = new Message("あれ～、買ったばかりの消しゴムがないンゴwww");
		msg2.setReaction(new Reaction("(^ ^)", 1));
		msg2.setReaction(new Reaction("(^o^)d", 0));
		msg2.setReaction(new Reaction("(- -;)", 3));

		msg1.display();

		System.out.println();

		msg2.display();
	}

}
