package playerdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBUtil {

	public static Connection dbConnection = null;

	/**
	 * @return Connection
	 */
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		if (dbConnection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbHost=System.getenv("DB_Host");
			String dbPort=System.getenv("DB_Port");
			String dbName=System.getenv("DB_Name");
			String dbUrl = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
			String dbUserName = System.getenv("DB_UserName");
			String dbPassword = System.getenv("DB_Password");
			dbConnection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}
		return dbConnection;
	}
	
	/**
	 * @param query
	 * @return queryResult
	 */
	public static HashMap<String, String> executeQueryForRead(String query)
			throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		ResultSet rs = null;
		HashMap<String, String> valueRead = null;
		try {
			stmt = getDbConnection().createStatement();
			rs = stmt.executeQuery(query);

			valueRead = getValueFromResultSet(rs);

		} catch (Exception e) {
			e.printStackTrace();
			e.getStackTrace();
		} finally {
			rs.close();
			stmt.close();

		}
		return valueRead;
	}

	/**
	 * @Desc get MetaData
	 * @param rs
	 */
	public static HashMap<String, String> getValueFromResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		HashMap<String, String> data = new HashMap<String, String>();
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i);
				data.put(columnName, rs.getString(i));
			}
		}
		return data;
	}
	

	/**
	 * @Desc Close Db Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void closeDbConnection() throws ClassNotFoundException, SQLException {
		getDbConnection().close();
	}
}

