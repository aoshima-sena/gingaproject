package main.practice20230410.question7;

public class Robot {
	int id;
	String name;
	 static int total;

	public  Robot(String name) {
		this.name = name;

			total ++;
			this.id +=total;

	}

	public static  int getTotal() {
		return total;
	}

	public void introduce() {
		System.out.println("ID：" + this.id + "NAME：" + this.name );
	}

}
