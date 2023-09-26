package main.rennshu;

import java.util.HashSet;
import java.util.Set;

public class Rennshu10 {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();

		hs.add("りんご");
		hs.add("みかん");
		hs.add("バナナ");
		hs.add("ぶどう");

		hs.remove("みかん");

		System.out.println(hs);

		System.out.println(hs.contains("バナナ"));

		System.out.println(hs.contains("みかん"));
	}

}
