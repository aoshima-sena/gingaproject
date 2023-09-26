package jp.co.ginga.infra.facility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import jp.co.ginga.infra.repository.facility.FacilityEntity;
import jp.co.ginga.infra.repository.facilitytype.FacilityTypeEntity;

@SpringBootTest
public class FacilityRepositoryJDBCTest {
	//JDBCクラスは本来のデータベース上で動いているから、どうにかしてテスト用に変更しないといけない。

	String dbUrl = "jdbc:postgresql://localhost:5432/spring_test";
	String dbUser = "spring";
	String dbPassword = "spring";

	ResultSet rs = null;
	PreparedStatement prepared = null;
	Connection connection = null;

	/*
	 * ---------------------------------------------------------------------------
	 */

	private Logger logger = LoggerFactory.getLogger(FacilityRepositoryJDBCSample.class);

	private static IDatabaseTester databaseTester;

	/**
	 * 正常に動いたけどナニコレ…
	 * めんど…
	 * @throws ClassNotFoundException
	 */
	@Test
	public void find_all_test() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			prepared = connection.prepareStatement(
					"select facility_id,m_facility.name,capacity,type.facility_type_id,type.name as typeName from m_facility left join m_facility_type as type on m_facility.facility_type_id = type.facility_type_id order by facility_id ");
			rs = prepared.executeQuery();

			List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();

			while (rs.next()) {
				int facilityId = rs.getInt("facility_id");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				int facilityTypeId = rs.getInt("facility_type_id");
				String typeName = rs.getString("typeName");

				FacilityTypeEntity typeEntity = new FacilityTypeEntity();
				FacilityEntity facilityEntity = new FacilityEntity();
				typeEntity.setFacilityTypeId(facilityTypeId);
				typeEntity.setName(typeName);
				facilityEntity.setFacilityId(facilityId);
				facilityEntity.setName(name);
				facilityEntity.setCapacity(capacity);
				facilityEntity.setFacilityTypeEntity(typeEntity);

				facilityEntityList.add(facilityEntity);

			}
			System.out.println(facilityEntityList);
			for (int i = 0; i < facilityEntityList.size(); i++) {
				assertEquals((i + 1), facilityEntityList.get(i).getFacilityId());
				assertEquals("会議室" + (i + 1), facilityEntityList.get(i).getName());
				assertEquals((i + 1) * 10, facilityEntityList.get(i).getCapacity());
				assertEquals((i + 1), facilityEntityList.get(i).getFacilityTypeEntity().getFacilityTypeId());
				assertEquals("会議室" + (i + 1), facilityEntityList.get(i).getFacilityTypeEntity().getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * --------------------------------------------------------------------------
	 */
	@BeforeEach
	public void setUp() throws Exception {
		logger.info("前処理");

		databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/spring",
				"spring", "spring");

		IDataSet dataSet = new FlatXmlDataSetBuilder()
				.build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
		databaseTester.setDataSet(dataSet);

		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.onSetup();
		logger.info("全処理終了");
	}

	@After
	public void tearDown() throws Exception {
		databaseTester.setTearDownOperation(DatabaseOperation.NONE);
		databaseTester.onTearDown();
	}

	//上のやつでよかったみたい…下のやついらん…↴
	//実際アップデートとかでならなんか使えそうでもないかも
	@Test
	@DatabaseSetup("./data/infra/repository/facility/setup_dataset_facility.xml")
	@ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void test() {
		logger.info("JUnit+DBUnit開始");
		//これの意味なに↴
		FacilityRepositoryJDBCSample.main(null);
		try {
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
					.build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
			ITable expectedTable = expectedDataSet.getTable("m_facility");

			IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("m_facility");

			ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(expectedTable,
					new String[] { "facility_id" });
			System.out.println(filteredExpectedTable);

			ITable filteredActualeTable = DefaultColumnFilter.excludedColumnsTable(actualTable,
					new String[] { "facility_id" });

			Assertion.assertEquals(filteredExpectedTable, filteredActualeTable);
		} catch (Exception e) {
			logger.error("error", e);
			fail("予期しないエラー");
		}
		logger.info("JUnit+ DBUnitによるテスト開始");
	}

	/*
	 * -----------------------------------------------------------------------------------------------------
	 */
	//	private static IDatabaseTester databaseTester;
	//	private FacilityRepositoryJDBCSample sample;
	//
	//	@Before
	//	public void setUp() throws Exception {
	//		databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/spring_test",
	//				"spring", "spring");
	//
	//		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
	//		databaseTester.setDataSet(dataSet);
	//		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
	//		databaseTester.onSetup();
	//
	//		sample = new FacilityRepositoryJDBCSample();
	//	}
	//
	//	@After
	//	public void tearDown() throws Exception {
	//		databaseTester.setTearDownOperation(DatabaseOperation.NONE);
	//		databaseTester.onTearDown();
	//	}
	//
	//	@Test
	//	public void state_findAll() throws Exception, Exception {
	//		sample.execute();
	//		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
	//		ITable expectedTable = expectedDataSet.getTable("m_facility");
	//
	//		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
	//		ITable actualTable = databaseDataSet.getTable("m_facility");
	//		ITable sortedTable = new SortedTable(actualTable,new String[] {"facility_id"});
	//
	//		Assertion.assertEquals(expectedTable, sortedTable);
	//	}

	//	@Autowired
	//	JdbcTemplate jdbctemplate;
	//	@Autowired
	//	FacilityRepositoryJDBC facilityRepository;
	//
	//	String item_id_str = null;
	//	private File file = null;
	//
	//	private FileOutputStream out;
	//	private FileInputStream in ;
	//	File tempDir = new File("./data/infra/repository/facility");
	//
	//	@BeforeTransaction
	//	public void initdb() throws Exception {
	//		Connection connection = jdbctemplate.getDataSource().getConnection();
	//		IDatabaseConnection dbconnection = new DatabaseConnection(connection);
	//		try {
	//			String sql = "SHOW TABLE STATUS where name = 'm_facility'";
	//			PreparedStatement statement = connection.prepareStatement(sql);
	//			ResultSet result = statement.executeQuery();
	//			while(result.next()) {
	//				item_id_str = result.getString("Auto_increment");
	//			}
	//
	//			QueryDataSet partialDataSet = new QueryDataSet(dbconnection);
	//			partialDataSet.addTable("m_facility");
	//			file = File.createTempFile("m_facility",".xml", tempDir);
	//			out = new FileOutputStream(file);
	//			FlatXmlDataSet.write(partialDataSet, out);
	//			out.flush();
	//			out.close();
	//
	//			IDataSet dataset = new XlsDataSet(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
	//			DatabaseOperation.CLEAN_INSERT.execute(dbconnection,dataset);
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//		}finally {
	//			connection.close();
	//			dbconnection.close();
	//		}
	//	}
	//
	//	@AfterTransaction
	//	public void teardown() throws Exception {
	//		Connection connection = jdbctemplate.getDataSource().getConnection();
	//		IDatabaseConnection dbconnection = new DatabaseConnection(connection);
	//		try {
	//			in = new FileInputStream(file);
	//			IDataSet dataSet = new FlatXmlDataSetBuilder().build(in);
	//			DatabaseOperation.CLEAN_INSERT.execute(dbconnection,dataSet);
	//
	//			String sql = new StringBuilder("ALTER TABLE m_facility AUTO_INCREMENT").append(item_id_str).toString();
	//			PreparedStatement statement = connection.prepareStatement(sql);
	//			statement.executeUpdate();
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//		}finally {
	//			connection.close();
	//			dbconnection.close();
	//			file.deleteOnExit();
	//		}
	//	}
	//
	//	@Test
	//	public void test_findAll() {
	//		FacilityEntity facilityEntity = new FacilityEntity();
	//		List<FacilityEntity> entityList = new ArrayList<FacilityEntity>();
	//		entityList =facilityRepository.findAll();
	//
	//		for(int i = 0;i < entityList.size() ; i++) {
	//			assertEquals(entityList.get(i).getFacilityId(),i);
	//			assertEquals(entityList.get(i).getName(),"会議室" +i);
	//			assertEquals(entityList.get(i).getCapacity(),i*10);
	//			assertEquals(entityList.get(i).getFacilityTypeEntity().getFacilityTypeId(),i);
	//			assertEquals(entityList.get(i).getFacilityTypeEntity().getName(),"会議室" +1);
	//
	//		}
	//
	//	}

	//	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	//	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/spring_test";
	//	private static final String USER = "spring";
	//	private static final String PASSWORD = "spring";
	//
	//	@BeforeClass
	//	public static void createSchema() {
	//		JdbcDataSource jd = new JdbcDataSource();
	//	}

	//	private Logger logger = LoggerFactory.getLogger(FaclityRepositoryJDBC.class);
	//
	//	private static IDatabaseTester databaseTester;
	//
	//	@Before
	//	public void setUp() throws Exception {
	//		logger.info("前処理開始");
	//
	//		/**
	//			* 事前準備データのINSERT
	//			*/
	//
	//		databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/spring_test",
	//				"spring", "spring");
	//
	//		/**
	//			* テストデータ導入
	//			*/
	//
	//		IDataSet dataSet = new FlatXmlDataSetBuilder()
	//				.build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
	//		databaseTester.setDataSet(dataSet);
	//
	//		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
	//		databaseTester.onSetup();
	//		logger.info("前処理終了");
	//	}
	//
	//	/**
	//		*DBUnitの後処理
	//		* @throws Exception
	//		*/
	//	@After
	//	public void tearDown() throws Exception {
	//		databaseTester.setTearDownOperation(DatabaseOperation.NONE);
	//		databaseTester.onTearDown();
	//	}
	//
	//	@Test
	//	public void findAll_test() {
	//		logger.info("JUnit + DBUnitによるテスト開始");
	//
	//		try {
	//			IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
	//					.build(new File("./data/infra/repository/facility/setup_dataset_facility.xml"));
	//			ITable expectedTable = expectedDataSet.getTable("m_facility");
	//
	//			IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
	//			ITable actualTable = databaseDataSet.getTable("m_facility");
	//
	//			ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(expectedTable,
	//					new String[] { "create_date" });
	//			ITable filteredAcutualTable = DefaultColumnFilter.excludedColumnsTable(actualTable,
	//					new String[] { "create_date" });
	//
	//			Assertion.assertEquals(filteredExpectedTable, filteredAcutualTable);
	//		} catch (Exception e) {
	//			logger.error("error", e);
	//			fail("予期しないエラーでテストが失敗しました");
	//		}
	//		logger.info("JUnit + DBUnitによるテスト開始");
	//	}
}
