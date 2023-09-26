package supermarketIBE;

// スーパーマーケット_イベにおにぎりが３つ入荷されました。
// まずは、正しい値段が書いてあるラベルを貼って陳列しよう（正しくインスタンス生成）
//
// その後、時間が経過したのでおにぎりに値引きシールを貼るところですが、
// うっかり割引率クラスを２つ用意し忘れて値引きができません、
// みんなの力で値引きシールを貼って（putDiscountSealメソッドを使って）、
// きちんと値引きして買い物をしよう！！
//
// 入荷商品と値引き率は下記を参照
// 120円のツナおにぎり
// 150円の鮭おにぎり -> ２割引きシールを貼る
// 180円の明太おにぎり -> 半額シールを貼る
// 値引き後の合計金額を求めてください
public class Store {
	public static void main(String[] args) {

		Onigiri tunaOnigiri = new Onigiri("ツナ",120);
		Onigiri sakeOnigiri = new Onigiri("鮭",150);
		Onigiri mentaiOnigiri = new Onigiri("明太",180);

		Waribiki waribiki = new Waribiki();
		Hangaku hangaku  = new Hangaku();

		putDiscountSeal(sakeOnigiri,waribiki);
		putDiscountSeal(mentaiOnigiri,hangaku);

		// ↓出力フィールド（「３つのおにぎりの合計金額は〇〇円です。」を実装）

		int goukei = tunaOnigiri.getPrice() + sakeOnigiri.getPrice() + mentaiOnigiri.getPrice();
	System.out.println("３つのおにぎりの合計金額は" + goukei + "円です。");


	}

	/** ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓触るな危険↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
	/**
	 * 値引きシールを貼る
	 */
	private static void putDiscountSeal(Onigiri onigiri, DiscountRate rate) {
		// 割引シールを貼って、おにぎりの割引後価格を算出
		double discountOnigiriPrice = rate.waribiki(onigiri.getPrice());
		// おにぎりの価格を設定しなおす
		onigiri.setPrice((int) discountOnigiriPrice);
		// どのおにぎりに値引きシールを貼ったかアナウンス
		System.out.println(onigiri.getLavel() + "おにぎりに値引きシールが貼られました。");
	}
	/** ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑触るな危険↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
}


// 回答の出力
//
//鮭おにぎりに値引きシールが貼られました。
//明太おにぎりに値引きシールが貼られました。
//
//３つのおにぎりの合計金額は330円です。
