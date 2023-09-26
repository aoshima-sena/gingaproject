package main.practice20230411.question12;

public class TotalHiLevelPractice {
	public static void main(String[] args) throws ShortFallException {
		// ホテルがオープン
		Hotel hotel = new Hotel("ホテルドルフィン");
		// ホテルに3人の従業員が出勤
		hotel.enter(new Staff("坂本", "清掃"));
		hotel.enter(new Staff("長野", "調理"));
		hotel.enter(new Staff("井ノ原", "接客"));
		System.out.println();
		// 3人のお客様がチェックイン（1人が所持金不足で泊まれず）
		hotel.enter(new Customer("岡田", 500000), Hotel.RoomRank.SUITE);
		hotel.enter(new Customer("三宅", 40000), Hotel.RoomRank.NORMAL);
		hotel.enter(new Customer("森田", 4000), Hotel.RoomRank.ECONOMY);
		System.out.println();
		// ホテルを運営
		hotel.manage();
		System.out.println();
		// お客様情報の確認
		hotel.showCustomerInfo();
		System.out.println();
		// ホテル情報の確認
		hotel.showHotelInfo();
	}
}
