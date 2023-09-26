package main.rennshu14;

import properties.Transferable;

public class Rennshu14 {

	public static void main(String[] args) {
		Transferable[] parts = {
				new Switch(),
				new Router()
		};

		for (Transferable work : parts) {
			work.transfer();
		}
	}
}
