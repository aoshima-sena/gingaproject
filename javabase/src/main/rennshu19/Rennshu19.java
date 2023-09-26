package main.rennshu19;

public class Rennshu19 {

	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(8);
		Node n3 = new Node(12);
		Node n4 = new Node(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		//下のコードを書くと無限処理になる
		//	n4.next = n1;

		Node now = n1;

		while (now != null) {
			now.display();
			now = now.next;
		}
	}

}
