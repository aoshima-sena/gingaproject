package main.practice20230411.question12;

public class Customer extends Person {

	int money;

	public Customer(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public int pay(int useMoney) throws ShortFallException {
		if (money - useMoney <= 0) {
			throw new ShortFallException(name + "は所持金不足です");

		}
		money -= useMoney;

		return useMoney;

	}

	public String toString() {
		return name + "様　所持金：" + money + "円";
	}
}
