package main.practice20230410.question12;

import object.question12.CenterForward;
import object.question12.GoalKeeper;
import object.question12.SoccerPlayer;

public class AbstractNormalPractice {

	public static void main(String[] args) {
	       // センターフォワードオブジェクトの生成
        SoccerPlayer fwd = new CenterForward("田村", 11);
        // 自己紹介
        System.out.println(fwd);
        // ボールを処理
        fwd.kickBall();
        fwd.catchBall();
        System.out.println();
        // ゴールキーパーオブジェクトの生成
        SoccerPlayer keeper = new GoalKeeper("川島", 12);
        // 自己紹介
        System.out.println(keeper);
        // ボールを処理
        keeper.kickBall();
        keeper.catchBall();

	}

}
