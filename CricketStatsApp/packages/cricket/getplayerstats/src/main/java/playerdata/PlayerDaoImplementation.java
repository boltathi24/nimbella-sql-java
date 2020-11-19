package playerdata;

import java.sql.SQLException;
import java.util.HashMap;

public class PlayerDaoImplementation implements PlayerDao {

	/* (non-Javadoc)
	 * @see playerdata.PlayerDao#fetchData(java.lang.String)
	 */
	@Override
	public Player fetchData(String playerName) throws SQLException, ClassNotFoundException {
		Player playerData = new Player();

		HashMap<String, String> dbResult = DBUtil
				.executeQueryForRead("select * from Runs where PlayerName='" + playerName + "'");
		
		if (dbResult.size() > 0) {
			playerData.setAverage(Float.valueOf(dbResult.get("Average")));
			playerData.setHighScore(Integer.parseInt(dbResult.get("HighScore")));
			playerData.setPlayerId(Integer.parseInt(dbResult.get("PlayerId")));
			playerData.setPlayerName(dbResult.get("Average"));
			playerData.setTotalRuns(Integer.parseInt(dbResult.get("TotalRuns")));
			playerData.setPlayerName(dbResult.get("PlayerName"));
		}
		return playerData;

	}

}
