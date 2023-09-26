package main.practice20230411.question12;

public class Staff extends Person implements Workable {

	String jobType;

	public Staff(String name, String jobType) {
		this.name = name;
		this.jobType = jobType;
	}

	@Override
	public void work() {
		System.out.println(this.name + "が" + this.jobType + "を行いました");
	}

}
