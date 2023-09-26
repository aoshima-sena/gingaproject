package object2.question6;

public class Member {
	private int id;
	private String name;

	public Member(int id, String name) {
		this.id = id;
		this.name = name;

	}

	@Override
	public String toString() {
		return "ID" + id + "NAME:" + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Member)) {
			return false;
		}

		return this.id == ((Member) obj).id;

	}

	@Override
	public int hashCode() {
		return id;
	}
}
