package object.question15;

public class InheritanceInterfacePractice {
	public static void main(String[] args) {
		// ミュージシャン配列の作成
		Musician[] band = {
				new Vocalist("桜井"),
				new Guitarist("田原", "リードギター"),
				new Guitarist("中川", "ベース"),
				new ChrusDrummer("鈴木")
		};
		// ミュージックスタート！

		for (int i = 0; i < band.length; i++) {
			if (band[i] instanceof Singable) {
				((Singable) band[i]).sing();
			}

			if (band[i] instanceof Playable) {
				((Playable) band[i]).play();
			}
		}
	}
}
