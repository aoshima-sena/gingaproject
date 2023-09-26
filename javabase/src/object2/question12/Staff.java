package object2.question12;

public class Staff extends Person implements Workable {

	String jobType;

	public Staff(String name, String jobType) {
		this.name = name;
		this.jobType = jobType;
	}

	public void work() {
		System.out.println(name + "が" + jobType + "を行いました");
	}
}
