package main.practice20230411.question8;

public class MultiMillionaire extends Thread{

	CollectionBox box;

	public MultiMillionaire(CollectionBox box) {
		this.box = box;
	}
	@Override
	public void run() {
		for(int i =0;i<1000000;i++) {
			//メソッドを使用して位置を足していく
			box.contribute(1);

		}
	}
}
