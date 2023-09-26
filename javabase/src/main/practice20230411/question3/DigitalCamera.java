package main.practice20230411.question3;

import java.util.ArrayList;
import java.util.List;

public class DigitalCamera {

	List<String> memory ;

	public DigitalCamera() {
		 memory = new ArrayList<String>();
	}

	public void takePicture(String target) {
		System.out.println(target + "を撮影しました");
		memory.add(target);
	}

	public void showPictures() {
		System.out.println("★☆　画像一覧　☆★");
		for(String str : memory) {
			System.out.println(str + "の画像");
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
