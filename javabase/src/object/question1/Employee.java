package object.question1;

public class Employee {
	//privateをつけたほうがいい
	int id;
	String name;

	//	public Employee(int id,String name) {
	//		this.id = id;
	//		this.name = name;
	//	}

	public void setData(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
