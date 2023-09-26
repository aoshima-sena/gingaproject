package main.error.rennshu34;

public class ProductManager {
	public static Product[] products = {
			new Product("りんご", 150),
			new Product("みかん", 200),
			new Product("バナナ", 100),
			new Product("ぶどう", 250),
			new Product("キウイ", 150),
	};

	public static Product searchProduct(String name) throws BusinessException {
		for (int i = 0; i < products.length; i++) {
			if (products[i].name.equals(name)) {
				return products[i];
			}
		}
		throw new BusinessException("該当する商品がありません");
		//商品が存在しない。
		//	return null;
	}
}
