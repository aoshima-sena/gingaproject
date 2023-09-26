package main.rennshu;

import java.sql.Date;

public class Rennshu8ao {

	// 親クラス
	static int id;
	static String name;
	static Date date = new Date(System.currentTimeMillis());

	public Rennshu8ao(int id) {
		this.id = id;
	}

	public Rennshu8ao(String name) {
		this.name = name;
	}

	public static void answer() {
		System.out.println("ID" + id + " " + "名前:" + name + " " + "登録日時：現在日時(" + date + ")");
	}

}
