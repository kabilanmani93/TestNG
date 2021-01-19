package APITesting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseGSON {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * FileReader fname = new FileReader("JSON/GSON.json"); JsonObject jsonObject =
		 * new JsonParser().parse(fname).getAsJsonObject();
		 * 
		 * String pageName =
		 * jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
		 * System.out.println(pageName);
		 * 
		 * JsonArray arr = jsonObject.getAsJsonArray("posts"); for (int i = 0; i <
		 * arr.size(); i++) { String post_id =
		 * arr.get(i).getAsJsonObject().get("post_id").getAsString();
		 * System.out.println(post_id); }
		 * 
		 * 
		 * //API Response fname = new FileReader("JSON/APIResponse.json"); //JsonObject
		 * jsonObject1 = new JsonParser().parse(fname).getAsJsonObject();
		 * 
		 * JsonArray arr1 = new JsonParser().parse(fname).getAsJsonArray(); String
		 * RoleName =
		 * arr1.get(1).getAsJsonObject().get("SupportRoleName").getAsString();
		 * System.out.println(RoleName);
		 */

		FileReader fname = new FileReader("JSON/Aditya.json");
		JsonObject jsonObject = new JsonParser().parse(fname).getAsJsonObject();

		JsonArray arr = jsonObject.getAsJsonArray("records");

		//JsonArray arr = jsonObject.get("records").getAsJsonArray();
		String[] record_names = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			String Name = arr.get(i).getAsJsonObject().get("Name").getAsString();
			record_names[i] = Name;
			//System.out.println(Name);
		}

		for (String s : record_names) {
			System.out.println(s);
		}

	}

}
