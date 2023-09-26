package main.practice20230411.question5;



public class HashMapNormalPractice {

	public static void main(String[] args) {
		 // 金庫インスタンスの作成
        StrongBox guard = new StrongBox();
        // 秘密の言葉変数の宣言
        String secret = null;
        try {
            // 1つ目の宝物を格納
            secret = "sgf01";
            guard.store(secret, new Treasure("ダイヤの指輪"));
            // 2つ目の宝物を格納
            secret = "zkq02";
            guard.store(secret, new Treasure("真珠のネックレス"));
            // 3つ目の宝物を格納
            secret = "xrt03";
            guard.store(secret, new Treasure("金のブレスレット"));
            // 4つ目の宝物を格納（秘密の言葉が重複）
            secret = "xrt03";
            guard.store(secret, new Treasure("プラチナのイヤリング"));
        } catch(DuplicateSecretException e) {
            System.out.println("秘密の言葉「" + secret + "」はすでにつかわれています");
        }
        System.out.println();
        try {
            // 1つ目の宝物を取得
            secret = "sgf01";
            Treasure treasure1 = guard.getTreasure(secret);
            System.out.println(treasure1 + "をゲットしました！");
            // 2つ目の宝物を取得
            secret = "zkq02";
            Treasure treasure2 = guard.getTreasure(secret);
            System.out.println(treasure2 + "をゲットしました！");
            // 3つ目の宝物を取得（秘密の言葉が不正）
            secret = "xrr03";
            Treasure treasure3 = guard.getTreasure(secret);
            System.out.println(treasure3 + "をゲットしました！");
        } catch(IllegalSecretException e) {
            System.out.println("秘密の言葉「" + secret + "」は不正です");
        }

	}

}
