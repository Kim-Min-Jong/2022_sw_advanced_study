package jdbc;

import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCClient {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection 객체 사용, 종료 => dao, DBManager

		Class.forName("com.mysql.cj.jdbc.Driver");

		SimpleDao dao = new SimpleDaoImpl();

//				SimpleDto dto = new SimpleDto("오길동", "not null5", "기본값");
//				System.out.println( dao.insert(dto) ); // inㅓsert2()

//				SimpleDto dto = new SimpleDto(1, "홍길동", "not null", "기본값");
//				System.out.println( dao.insertDup(dto) );

//				SimpleDto dto = new SimpleDto("박길동", "not null", "기본값");
//				System.out.println( dao.insertWithoutDefaultValue(dto) );
		// insertWithoutDefaultValue

//				SimpleDto dto = new SimpleDto(2, "유길동", "not null 2", "기본값2");
//				System.out.println( dao.update(dto) );

//				SimpleDto dto = new SimpleDto(2, "유길동", "not null 2", "기본값2");
//				System.out.println( dao.delete(dto) );

//				SimpleDto dto = dao.detail(1);
//				System.out.println(dto);

//		ArrayList<SimpleDto> list = dao.list();
//		for (SimpleDto dto : list) {
//			System.out.println(dto);
//		}

				ArrayList<SimpleDto> list = dao.list("길");
				for (SimpleDto dto : list) {
					System.out.println(dto);
				}		
	}

}
