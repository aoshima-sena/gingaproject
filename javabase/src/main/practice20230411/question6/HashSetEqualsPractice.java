package main.practice20230411.question6;

import java.util.HashSet;

public class HashSetEqualsPractice {

	public static void main(String[] args) {
		// グループを結成
		HashSet<Member> group = new HashSet<Member>();
		// メンバーを追加
		group.add(new Member(1, "山田"));
		group.add(new Member(2, "高田"));
		group.add(new Member(3, "村田"));
		group.add(new Member(4, "吉田"));
		group.add(new Member(5, "川田"));
		// 偽物がメンバーとして追加！
		group.add(new Member(1, "ニセ山田"));
		// メンバー紹介
		for (Member member : group) {
			System.out.println(member);
		}
	}

}
