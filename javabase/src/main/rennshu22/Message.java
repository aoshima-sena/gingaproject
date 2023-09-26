package main.rennshu22;

public class Message {

	String sentence;
	Reaction[] actions = new Reaction[3];
	int count;

	public Message(String sentence) {
		this.sentence = sentence;

	}

	public void setReaction(Reaction action) {
		this.actions[count++] = action;
	}

	public void display() {
		System.out.println(sentence);
		System.out.println("----------");
		for (int i = 0; i < count; i++) {
			actions[i].display();
			System.out.print(" ");
		}
		System.out.println();

	}
}
