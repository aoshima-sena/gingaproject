package main.practice20230411.question6;

public class Member {

    private int id;        // ID
    private String name;         // 名前
    // コンストラクタ
    public Member(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "ID:" + id + " NAME:" + name;
    }

    @Override
    public boolean equals(Object id) {
    	if(this==id) {
    	return false;
    	}
    	if(!(id instanceof Member)) {
    		return false;
    	}

    	return this.id == ((Member)id).id;
    }

    @Override
    public int hashCode() {
    	return id;
    }
}
