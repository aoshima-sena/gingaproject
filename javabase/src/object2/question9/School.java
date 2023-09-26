package object2.question9;

public class School {

	private static final int CAPACITY = 5;

	private String name;
	private Student[] students;

	public School(String name) {
		this.name = name;
		students = new Student[CAPACITY];
	}

	public void enterSchool(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = new Student(i + 1, name);
				System.out.println(name + "さんが" + this.name + "に入学しました");
				return;
			}
		}
		System.out.println("定員オーバーで" + name + "さんは" + this.name + "に入学できません");
	}

	public void introduce() {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.println(students[i]);
			} else {
				break;
			}
		}

	}

	private class Student {

		private int id;
		private String name;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			//Schoolのnameを指定する↓
			return School.this.name + "に在学している出席番号" + id + "の" + name + "です。";
		}
	}
}
