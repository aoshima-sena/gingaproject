package object.question11;

import object.question11.animal.Bird;
import object.question11.animal.Cat;
import object.question11.animal.Dog;

public class AbstractBasicPractice {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];

		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Bird();

		//	animals[2].sing();

		for (int i = 0; i < animals.length; i++) {
			animals[i].sing();
		}
	}
}
