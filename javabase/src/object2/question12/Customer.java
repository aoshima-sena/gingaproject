package object2.question12;

public class Customer extends Person {
	//所持金
	private int money;

	public Customer(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public int pay(final int money) throws ShortFallException {
		if (this.money < money) {
			throw new ShortFallException(name + "は所持金不足です");
		} else {
			this.money -= money;
			return money;
		}
	}

	@Override
	public String toString() {
		return name + "様　所持金：" + money + "円";
	}
}
