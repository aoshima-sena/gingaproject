/**
 *
 */
package javabase;

/**
 * @author souken
 *
 */
public class Question12 {

	public static void main(String[] args) {
		System.out.println("あなたはここにあったパンを食べましたか?");
		Person realAnswer = new Person("太郎");
		realAnswer.answer();
		//Personで継承してるから呼び出せる
		Person liarAnswer = new LiarPerson("次郎");
		liarAnswer.answer();

		System.out.println("(ここだけの話、本当は?)");

		realAnswer.talkReal();
		liarAnswer.talkReal();

	}

}
