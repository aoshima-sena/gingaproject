package main.rennshu;

import java.util.HashMap;
import java.util.Map;

public class Rennshu11 {

	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<>();

		hm.put("国語", 90);
		hm.put("数学", 80);
		hm.put("英語", 70);

		for (Map.Entry<String, Integer> str : hm.entrySet()) {
			System.out.println(str.getKey() + ":" + str.getValue());
		}
	}
}
