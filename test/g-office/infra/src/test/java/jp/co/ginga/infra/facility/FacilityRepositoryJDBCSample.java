package jp.co.ginga.infra.facility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FacilityRepositoryJDBCSample {

	private static final String SQL = "select facility_id,m_facility.name,capacity,type.facility_type_id,type.name as typeName from m_facility left join m_facility_type as type on m_facility.facility_type_id = type.facility_type_id order by facility_id ";

	public static void main(String[] args) {
		try(Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring_test","spring","spring");
			PreparedStatement stmt = conn.prepareStatement(SQL);
				){
			conn.setAutoCommit(false);
			stmt.executeQuery();
			conn.commit();
		}catch(Exception e) {
			System.out.println("failed");

		}
	}
}
