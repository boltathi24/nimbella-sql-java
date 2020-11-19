package playerdata;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Get Player Data by name!
 *
 */
public class GetPlayerData {
	public static JsonObject main(JsonObject args) throws Exception {
		JsonObject response = new JsonObject();
		JsonObject headers = new JsonObject();
		headers.addProperty("content-type", "application/json;charset=UTF-8");
		response.add("headers", headers);		
		try {
			Gson gson = new Gson();
			String playerName = args.get("PlayerName").getAsString(); // Getting the playerName from Client Request
			
			PlayerDaoImplementation playerDao = new PlayerDaoImplementation(); // Database AccessObject

			Player playerData = playerDao.fetchData(playerName); // Getting Player Data

			JsonObject playerDataJson = new JsonObject();

			playerDataJson.add("data", gson.toJsonTree(playerData)); // Convert the DBResult (HashMap) into JSON Data
			if (playerData.getPlayerName() != null) {
				playerDataJson.addProperty("message", "Player Data Fetched Successfully");
			} else {
				playerDataJson.addProperty("message", "Player Data Not Found");
			}
			response.add("body", gson.toJsonTree(playerDataJson)); // Adding the response with the json attribute named
																	// body
			response.addProperty("statusCode", 200); // Adding the Status Code

			return response;
		} catch (Exception e) {
			response.addProperty("body", "Exception Occured :" + e.toString());
			response.addProperty("statusCode", 400);
			return response;
		}
	}

	
	
}
