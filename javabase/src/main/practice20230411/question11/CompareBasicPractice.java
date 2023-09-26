package main.practice20230411.question11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareBasicPractice {

	public static void main(String[] args) {
		// 小学生たちがいる教室を表現するArrayList型変数
		ArrayList<SchoolChild> classroom = new ArrayList<SchoolChild>();
		// 5人の生徒が教室にいます
		classroom.add(new SchoolChild(4, "武藤", 145.0));
		classroom.add(new SchoolChild(2, "佐藤", 130.0));
		classroom.add(new SchoolChild(5, "加藤", 162.5));
		classroom.add(new SchoolChild(1, "伊藤", 155.3));
		classroom.add(new SchoolChild(3, "江藤", 151.1));
		// 生徒たちの情報を表示（整列前）
		System.out.println("整列前");
		for (SchoolChild sc : classroom) {
			System.out.println(sc);
		}
		System.out.println();
		// 先生からの指示「出席番号順に整列しなさい」
		Collections.sort(classroom);
		// 生徒たちの情報を表示（出席番号順）
		System.out.println("出席番号順");
		for (SchoolChild sc : classroom) {
			System.out.println(sc);
		}
		System.out.println();
		// 先生からの指示「身長の高い順に整列しなさい」
		Collections.sort(classroom, new Comparator<SchoolChild>() {
			public int compare(SchoolChild sc1, SchoolChild sc2) {
				return sc1.getHeight() == sc2.getHeight() ? 0 : (sc1.getHeight() > sc2.getHeight() ? -1 : 1);
			}
		});
		// 生徒たちの情報を表示（身長の高い順）
		System.out.println("身長の高い順");
		for (SchoolChild sc : classroom) {
			System.out.println(sc);
		}

	}

}
