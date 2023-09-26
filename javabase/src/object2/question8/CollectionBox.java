package object2.question8;

public class CollectionBox {
	//1回だけしか生成できないようにする（シングルトン）
	private static CollectionBox cb;
	private int totalAmount;

	private CollectionBox() {

	}

	//シングルトン
	public static CollectionBox getInstance() {
		//インスタンスされなければ生成する
		if (cb == null) {
			cb = new CollectionBox();
		}

		return cb;
	}

	//synchronized でロックてきな役割をする
	public synchronized void contribute(int money) {
		totalAmount += money;

	}

	public int getTotalAmount() {
		return totalAmount;
	}

}
