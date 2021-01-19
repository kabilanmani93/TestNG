package APITesting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WriteJson
{
	    public static void main(String[] args) throws IOException  
	    { 
	        // creating JSONObject 
	        JSONObject jo = new JSONObject(); 
	          
	        // putting data to JSONObject 
	        jo.put("firstName", "John"); 
	        jo.put("lastName", "Smith"); 
	        jo.put("age", 25); 
	          
	        // for address data, first create LinkedHashMap 
	        Map m = new LinkedHashMap(4); 
	        m.put("streetAddress", "21 2nd Street"); 
	        m.put("city", "New York"); 
	        m.put("state", "NY"); 
	        m.put("postalCode", 10021); 
	          
	        // putting address to JSONObject 
	        jo.put("address", m); 
	          
	        // for phone numbers, first create JSONArray  
	        JSONArray ja = new JSONArray(); 
	          
	        m = new LinkedHashMap(2); 
	        m.put("type", "home"); 
	        m.put("number", "212 555-1234"); 
	          
	        // adding map to list 
	        ja.add(m); 
	          
	        m = new LinkedHashMap(2); 
	        m.put("type", "fax"); 
	        m.put("number", "212 555-1234"); 
	          
	        // adding map to list 
	        ja.add(m); 
	          
	        // putting phoneNumbers to JSONObject 
	        jo.put("phoneNumbers", ja); 
	          
	        // writing JSON to file:"JSONExample.json" in cwd 
	        FileWriter file = new FileWriter("JSONExample.json"); 
	        file.write(jo.toJSONString()); 
	          
	        file.flush(); 
	        file.close(); 
	    } 
	} 


