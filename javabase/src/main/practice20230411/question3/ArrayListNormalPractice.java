package main.practice20230411.question3;

public class ArrayListNormalPractice {

	public static void main(String[] args) {
		   // デジカメオブジェクトの宣言と生成
        DigitalCamera myCamera = new DigitalCamera();
        // デジカメにて撮影
        myCamera.takePicture("子猫");
        myCamera.takePicture("ランチ");
        myCamera.takePicture("カプチーノ");
        myCamera.takePicture("赤ちゃん");
        myCamera.takePicture("ツーショット");
        System.out.println();
        // 撮影画像数の確認
        System.out.println("現在の撮影枚数：" + myCamera.getPictureCount());
        System.out.println();
        // 画像の閲覧
        myCamera.showPictures();
        System.out.println();
        // 画像ファイルのクリア
        myCamera.clearMemory();
        System.out.println();
        // 撮影画像数の再確認
        System.out.println("現在の撮影枚数：" + myCamera.getPictureCount());

	}

}
