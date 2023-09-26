package main.rennshu22;

public class Reaction {

	String face;
	int count;

	public Reaction(String face, int count) {
		this.face = face;
		this.count = count;
	}

	public void display() {
		System.out.print(face + " : " + count);
		//	System.out.print(" : ");
		//	System.out.print(count);
	}

}
