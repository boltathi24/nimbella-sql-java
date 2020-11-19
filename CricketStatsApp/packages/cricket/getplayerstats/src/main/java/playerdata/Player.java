package playerdata;

public class Player {
	
	int PlayerId;
	String PlayerName;
	public int getPlayerId() {
		return PlayerId;
	}
	public void setPlayerId(int playerId) {
		PlayerId = playerId;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public float getAverage() {
		return Average;
	}
	public void setAverage(float average) {
		Average = average;
	}
	public int getTotalRuns() {
		return TotalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		TotalRuns = totalRuns;
	}
	public int getHighScore() {
		return HighScore;
	}
	public void setHighScore(int highScore) {
		HighScore = highScore;
	}
	float Average;
	int TotalRuns;
	int HighScore;
	

}
