package main.practice20230411.question5;

import java.util.HashMap;

public class StrongBox {

	HashMap<String, Treasure> treasures;

	public StrongBox() {
		treasures = new HashMap<String, Treasure>();
	}

	public void store(String language, Treasure treasure) throws DuplicateSecretException {
		if (treasures.containsKey(language)){
			throw new DuplicateSecretException();
		} else {
			System.out.println(treasure + "を金庫に格納しました！");
			this.treasures.put(language, treasure);
		}
	}

	public Treasure getTreasure(String language) throws IllegalSecretException {
		if (treasures.get(language) == null) {
			throw new IllegalSecretException();
		} else {
			return treasures.get(language);
		}
	}

}
