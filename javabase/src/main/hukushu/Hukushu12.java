package main.hukushu;

public class Hukushu12 {

	public static void main(String[] args) {
		System.out.println("あなたはここにあったパンを食べましたか？");
		Person person = new Person("太郎");
		person.answer();
		LiarPerson lPerson = new LiarPerson("次郎");
		lPerson.answer();

		System.out.println("（ここだけの話本当は？）");
		person.talkReal();
		lPerson.talkReal();
	}

}
