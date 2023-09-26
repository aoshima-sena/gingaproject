package jp.co.ginga.infra.repository.facility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;
@Repository
public class FacilityRepositoryJDBC {

	public List<FacilityEntity> findAll() {
		System.out.println("findAll開始");
		//application.properties参照
		//Postgres接続
		String dbUrl = "jdbc:postgresql://localhost:5432/spring";
		String dbUser = "spring";
		String dbPassword = "spring";

		ResultSet rs = null;
		PreparedStatement prepared = null;
		Connection connection = null;

		try {
			//ドライバー取得
			Class.forName("org.postgresql.Driver");

			//データベース接続
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			// SQLをデータベースに送るための準備を行うpreparedStatementにつめる。
			prepared = connection.prepareStatement(
					"select facility_id,m_facility.name,capacity,type.facility_type_id,type.name as typeName from m_facility left join m_facility_type as type on m_facility.facility_type_id = type.facility_type_id order by facility_id ");
			//SQLの実行
			rs = prepared.executeQuery();

			//データベースから取得したデータをEntityにつめる。（マッピング）
			List<FacilityEntity> list = new ArrayList<FacilityEntity>();

			while (rs.next()) {
				int facilityId = rs.getInt("facility_id");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				int facilityTypeId = rs.getInt("facility_type_id");
				String typeName = rs.getString("typeName");

				FacilityEntity entity = new FacilityEntity();
				entity.setFacilityId(facilityId);
				entity.setName(name);
				entity.setCapacity(capacity);
				FacilityTypeEntity typeEntity = new FacilityTypeEntity();
				typeEntity.setFacilityTypeId(facilityTypeId);
				typeEntity.setName(typeName);
				entity.setFacilityTypeEntity(typeEntity);

				list.add(entity);

			}
			return list;

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (prepared != null) {
					prepared.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
