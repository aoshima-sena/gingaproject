package main.error.rennshu34;

public class Rennshu34 {
	public static void main(String[] args) {
		try {
			System.out.println(ProductManager.searchProduct("りんご"));
			System.out.println(ProductManager.searchProduct("メロン"));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}
}
