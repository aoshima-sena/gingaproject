package main.rennshu;

public class Rennshu8 {
	//継承するときはあんまりstaticつけないほうがいい
	//クラスに依存して順番が違うだけで上書きされることがある
	public static void main(String[] args) {
		// ①ID：0001 名前：山田太郎 登録日時：現在日時(yyyy/mm/dd)
		//②ID：0002 名前：鈴木花子 登録日時：現在日時(yyyy/mm/dd)
		//③ID：0003 名前：佐藤琢磨 登録日時：現在日時(yyyy/mm/dd)

				Rennshu8ao.id = 54;
				Rennshu8ao.name = "名前？";

				Rennshu8ao.answer();

				Rennshu8nr.id = 6;
				Rennshu8nr.name = "名前かぁ";

				Rennshu8nr.answer();

//		Rennshu8ao aoId = new Rennshu8ao(54);
//		Rennshu8ao aoName = new Rennshu8ao("名前？");
//		Rennshu8nr7 nrId = new Rennshu8nr(6);
//		Rennshu8nr nrName = new Rennshu8nr("名前かぁ");
//
//		aoName.answer();
//		nrName.answer();

	}

}
