package main.rennshu14;

import properties.Transferable;

public class Router implements Transferable {

	@Override
	public void transfer() {
		System.out.println("IPアドレスを使ってデータを転送します");
	}

}
