package javabase;

public class LiarPerson extends Person {

	public LiarPerson(String name) {
		super(name);
	}

	@Override
	public void talkReal() {
		System.out.println(name + "（はい、食べました。）");
	}

}
