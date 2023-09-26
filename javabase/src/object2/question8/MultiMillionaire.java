package object2.question8;

public class MultiMillionaire extends Thread {

	private CollectionBox collectionBox;

	public MultiMillionaire(CollectionBox collectionBox) {
		this.collectionBox = collectionBox;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			collectionBox.contribute(1);
		}
	}
}
