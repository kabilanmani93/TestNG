package APITesting;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadorgJSON {

	public static void main(String[] args) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		
	    //------------------------------------- org.json
	    //JSONObject obj = new JSONObject(response);
        //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        //System.out.println(pageName);

	     //-since its already an array no need to create instance of json object
		//No parser in org.json
	 	FileReader fname = new FileReader("JSON/APIResponse.json");		
	    JSONArray json = new JSONArray(new JSONTokener(fname));
        String Name = json.getJSONObject(1).getString("SupportRoleName");
         System.out.println(Name);	
	    
        /*for (int i = 0; i < json.length(); i++)
       {
         String Name = json.getJSONObject(i).getString("SupportRoleName");
         System.out.println(Name);				
	    }*/
 }

	}


