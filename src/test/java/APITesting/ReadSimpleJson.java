package APITesting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ReadSimpleJson {

public static void main(String[] args) throws Exception
{
		// TODO Auto-generated method stub
		
		//Parsing
		JSONParser parser = new JSONParser();
		FileReader fname = new FileReader("JSON/JSONExample.json");		
		Object obj =  parser.parse(fname);


		//typecast obj to json object
		JSONObject jo = (JSONObject) obj;
		
		//first Name and Last Name
		String firstName = (String) jo.get("firstName");
		String lastName = (String) jo.get("lastName"); 
         
	    System.out.println(firstName); 
	    System.out.println(lastName); 
	    
	    //get Address {ke1: val1, key 2 , val 2}
	    Map<String, Object> address = (Map<String, Object>) jo.get("address");

	    //foreach
	    for(Entry<String, Object> map : address.entrySet())
		{
			System.out.println(map.getKey() + " : " + map.getValue());
		}

		//Iterator
	    Iterator itr1 = address.entrySet().iterator();
        while (itr1.hasNext())
        {
            Entry<String, Object> pair = (Entry<String, Object>) itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        //PhoneNumbers
        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
        Iterator itr2 = ja.iterator();
        while(itr2.hasNext())
        {
        	Map<String, Object> Phone_Numbers = (Map<String, Object>) itr2.next();
           // itr1 = Phone_Numbers.entrySet().iterator();
        	for(Entry<String, Object> PhoneNumber : Phone_Numbers.entrySet())
	       	    {
	       	    	System.out.println(PhoneNumber.getKey() + " : " + PhoneNumber.getValue());
	       	    }
        }

	}



}
