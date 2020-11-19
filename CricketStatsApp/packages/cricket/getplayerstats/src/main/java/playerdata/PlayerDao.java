package playerdata;

import java.sql.SQLException;

public interface PlayerDao {
	
	public Player fetchData(String player) throws SQLException,ClassNotFoundException; 

}
