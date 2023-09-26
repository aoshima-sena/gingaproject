package object2.question12;

import java.util.ArrayList;

public class Hotel {

	private String name;
	private long profits;
	private ArrayList<Staff> staffs;
	private ArrayList<Customer> customers;

	public enum RoomRank {
		SUITE("スイートルーム", 100000), NORMAL("通常ルーム", 20000), ECONOMY("格安ルーム", 5000);

		private String roomRankName;

		private int price;

		private RoomRank(final String roomRankName, final int price) {
			this.roomRankName = roomRankName;
			this.price = price;
		}

		private int getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return roomRankName;
		}
	}

	public Hotel(final String name) {
		this.name = name;
		System.out.println(name + "がオープンしました");
		staffs = new ArrayList<Staff>();
		customers = new ArrayList<Customer>();
	}

	//従業員が入る
	public void enter(final Staff staff) {
		System.out.println(staff.getName() + "が" + name + "に出勤しました");

		staffs.add(staff);
	}

	//客が入る
	public void enter(final Customer customer, final RoomRank rank) {
		try {
			profits += customer.pay(rank.getPrice());

			System.out.println(customer.getName() + "様が" + name + "の" + rank + "にお泊まりになります");

			customers.add(customer);
		} catch (ShortFallException e) {
			System.out.println(e.getMessage());
		}
	}

	public void manage() {
		for (Staff staff : staffs) {
			staff.work();
		}
	}

	public void showCustomerInfo() {
		System.out.println("お客様情報");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public void showHotelInfo() {
		System.out.println(name + "の現在の状況");
		System.out.println("現在働いている従業員数：" + staffs.size() + "名");
		System.out.println("現在お泊まりのお客様数：" + customers.size() + "名");
		System.out.println("現在の利益：" + profits + "円");
	}

}
