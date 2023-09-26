package main.Test;

public class Test {

	public static void main(String[] args) {
		Class a = new Class();
		a.id = "ID1";
		a.value = 1;

		Class b = a;
		b.id = "ID2";
		b.value = 2;

		b =null;

		System.out.println("id : " + a.id);
		System.out.println("value : " + a.value);
	}
}
