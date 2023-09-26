package main.collection;

import java.util.HashSet;
import java.util.Set;

public class Rennshu36 {
	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();

		set.add("りんご");
		set.add("みかん");
		set.add("バナナ");
		set.add("ぶどう");

		set.remove("みかん");

		System.out.println(set);

		if (set.contains("バナナ")) {
			System.out.println("true");

		} else {
			System.out.println("false");
		}
		if (set.contains("みかん")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
