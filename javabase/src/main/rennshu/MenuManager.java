package main.rennshu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuManager {

	Map<String, ArrayList> map = new HashMap<String, ArrayList>();

	//mapにmenuとlist(menuの種類を入れている)
	MenuManager() {

		ArrayList<String> list = new ArrayList<>();
		list.add("ハンバーガー");
		list.add("チーズバーガー");
		list.add("ダブルチーズバーガ―");

		map.put("sandwitch", list);

		list = new ArrayList<>();
		list.add("コーラ");
		list.add("オレンジジュース");
		list.add("ミネラルウォーター");

		map.put("drink", list);

		list = new ArrayList<>();
		list.add("フライドポテト");
		list.add("チキンナゲット");
		list.add("フレッシュサラダ");

		map.put("sidemenu", list);
	}

	void searchMenu(String menu) {
		//menuのsandwitchとdrinkとsidemenuで回す
		for (String key : map.keySet()) {
			//mapのkeyからlistのなかに含まれているか確認
			if (map.get(key).contains(menu)) {
				System.out.println(menu + "は" + key + "に含まれています。");
				return;
			}
		}
		System.out.println("該当するメニューはありません。");
	}

	void setMenu(String category, String menu) {

		//sandwicthとdrinkとsidemenuの中にmenuを追加する
		map.get(category).add(menu);
	}

	void showMenu(String category) {
		System.out.println(map.get(category));
	}

}
