package object2.question3;

import java.util.ArrayList;

public class DigitalCamera {

	//コンポジション
	private ArrayList<Picture> memory;

	public DigitalCamera() {
		memory = new ArrayList<Picture>();
	}

	public void takePicture(String target) {
		System.out.println(target + "を撮影しました。");
		memory.add(new Picture(target));
	}

	public void showPictures() {
		System.out.println("★☆　画像一覧　☆★");

		for (Picture picture : memory) {
			System.out.println(picture);
		}

	}

	public int getPictureCount() {
		return memory.size();
	}

	public void clearMemory() {
		memory.clear();
		System.out.println("すべての画像を消去しました");
	}
}
