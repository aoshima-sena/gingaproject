package main.object.rennshu41;

public class Triangle {
	public int bottom; //底辺
	public int height; //高さ

	public Triangle(int bottom, int height) {
		this.bottom = bottom;
		this.height = height;
	}

	public String toString() {
		return "底辺：" + this.bottom + "高さ：" + this.height + "面積：" + (this.bottom * this.height / 2);
	}

	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (obj instanceof Triangle) {
			Triangle triangle = (Triangle) obj;
			if (this.bottom == triangle.bottom && this.height == triangle.height) {
				return true;
			}
		}
		return false;
	}
}
