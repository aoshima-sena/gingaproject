package object2.question5;

import java.util.HashMap;

public class StrongBox {
	private HashMap<String, Treasure> treasures;

	public StrongBox() {
		treasures = new HashMap<String, Treasure>();
	}

	public void store(String secret, Treasure treasure) throws DuplicateSecretException {
		if (treasures.containsKey(secret)) {
			throw new DuplicateSecretException();
		} else {
			System.out.println(treasure + "を金庫に格納しました");

			treasures.put(secret, treasure);
		}
	}

	public Treasure getTreasure(String secret) throws IllegalSecretException {
		Treasure treasure = treasures.get(secret);

		if (treasure == null) {
			throw new IllegalSecretException();
		} else {
			return treasure;
		}
	}
}
