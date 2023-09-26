package main.practice20230410.question11;

public class AbstractBasicPractice {

	public static void main(String[] args) {
		Animal animal[] = new Animal[3];
		animal[0] = new Dog();
		animal[1] = new Cat();
		animal[2] = new Bird();

		for (int i = 0;i < animal.length;i++) {
			animal[i].sing();
		}


	}

}
