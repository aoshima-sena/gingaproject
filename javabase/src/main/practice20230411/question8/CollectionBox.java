package main.practice20230411.question8;

public class CollectionBox {

	int totalAmout;

	//外部からアクセスしないように
	private CollectionBox() {
		this.totalAmout = 0;
	}

	public static CollectionBox getInstance() {
		//ここでif文でnullかどうか見たら一回だけしかインスタンス生成できないようになる
		return new CollectionBox();
	}

	//ロックフラグを立てる↓
	//一人が募金するのを待つためにsynchronizedをつける必要がある
	//同期処理をする
	public synchronized void contribute(int money) {

		this.totalAmout += money;

	}

	public int getTotalAmout() {
		if (totalAmout != 5000000) {
			System.out.println("error");

		}
		return totalAmout;
	}
}
