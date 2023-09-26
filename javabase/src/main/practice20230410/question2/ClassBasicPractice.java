package main.practice20230410.question2;

public class ClassBasicPractice {

	public static void main(String[] args) {
	     // 1匹目のペットオブジェクトの生成
        Pet pet1 = new Pet();

        // 1匹目のペットデータを設定
        pet1.setType("犬");
        pet1.setName("コタロー");
        pet1.setAge((byte)4);
        pet1.setGender(false);

        // 2匹目のペットオブジェクトの生成
        Pet pet2 = new Pet();

        // 2匹目のペットのデータを設定
        pet2.setType("猫");
        pet2.setName("ミー");
        pet2.setAge((byte)2);
        pet2.setGender(true);

        // 2匹のペットの紹介文を取得し、表示する
        System.out.println(pet1.getIntroduction());
        System.out.println(pet2.getIntroduction());
	}

}
