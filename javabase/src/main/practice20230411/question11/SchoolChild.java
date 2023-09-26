package main.practice20230411.question11;

public class SchoolChild implements Comparable<SchoolChild>{
	private int no;        // 出席番号
    private String name;        // 名前
    private double height;        // 身長
    // コンストラクタ
    public SchoolChild(final int no, final String name, final double height) {
        this.no = no;
        this.name = name;
        this.height = height;
    }
    // 出席番号の取得
    public int getNo() {
        return no;
    }
    // 名前の取得
    public String getName() {
        return name;
    }
    // 身長の取得
    public double getHeight() {
        return height;
    }
    @Override
    public String toString() {
        return "出席番号：" + no + "　名前：" + name + "　身長：" + height;
    }

	public int compareTo(SchoolChild sc) {

		return no ==sc.getNo() ? 0:(no>sc.getNo() ?1 : -1);
	}

}
