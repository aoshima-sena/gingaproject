package main.practice20230410.question13;

import object.question13.Athlete;
import object.question13.MarathonRunner;
import object.question13.Swimmer;

public class AbstractCastPractice {

	public static void main(String[] args) {
		// アスリート配列オブジェクトの生成
		Athlete[] athlete = {
				new Swimmer("北島光一"),
				new MarathonRunner("高橋昭子"),
				new Swimmer("岩崎正子"),
				new MarathonRunner("野口みきえ")
		};
		// 自己紹介
		for (int i = 0; i < athlete.length; i++) {
			System.out.println(athlete[i]);
		}
		System.out.println();
		// ここから作業してください
		// アスリートの種目に応じたメソッドの実行

		for(int i = 0;i<athlete.length;i++ ) {
			if(athlete[i].getType() =="水泳") {
				((Swimmer)athlete[i]).swim();
			}else if(athlete[i] instanceof MarathonRunner){
				 ((MarathonRunner)athlete[i]).run();
			}
		}
	}

}
