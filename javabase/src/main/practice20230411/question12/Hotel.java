package main.practice20230411.question12;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private String name;
	private long profits;
	private List<Staff> staff;
	private List<Customer> customers;

	enum RoomRank {
		SUITE("スイートルーム", 100000), NORMAL("通常ルーム", 20000), ECONOMY("格安ルーム", 5000);

		String roomRankName;
		int price;

		RoomRank(String roomRankName, int price) {
			this.roomRankName = roomRankName;
			this.price = price;
		}

		public int getPrice() {
			return price;
		}

		public String toString() {
			return roomRankName;
		}

	}

	public Hotel(String name) {
		this.name = name;
		System.out.println(this.name + "がオープンしました");
		staff = new ArrayList<Staff>();
		customers = new ArrayList<Customer>();
	}

	public void enter(Staff staff) {

		this.staff.add(staff);
		System.out.println(staff.getName() + "が" + this.name + "に出勤しました");

	}

	public void enter(Customer customer, RoomRank roomRank) throws ShortFallException {
		try {


			profits += customer.pay(roomRank.getPrice());

			System.out.println(customer.getName() + "様が" + this.name + "の" + roomRank + "にお泊りになります");
			this.customers.add(customer);
		} catch (ShortFallException e) {
			System.out.println(e.getMessage());
		}

	}

	public void manage() {
		for (Staff st : staff) {
			st.work();
		}
	}

	public void showCustomerInfo() {
		System.out.println("お客様情報");
		for (Customer cs : customers) {
			System.out.println(cs);
		}

	}

	public void showHotelInfo() {
		System.out.println("ホテルドルフィンの現在の状況");
		System.out.println("現在働いている従業員数：" + staff.size() + "名");
		System.out.println("現在お泊りのお客様数：" + customers.size() + "名");
		System.out.println("現在の利益：" + profits);
	}
}
