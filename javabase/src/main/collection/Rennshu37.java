package main.collection;

import java.util.HashMap;
import java.util.Map;

public class Rennshu37 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("国語", 90);
		map.put("数学", 80);
		map.put("英語", 70);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			System.out.println(entry.getKey() + ":" + entry.getValue());
			;

		}

	}
}
