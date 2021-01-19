package APITesting;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

//What you get after get(baseQUARL).then()... is a ValidatableResponse,
//you can try and use get(baseQAURL).then().extract().response()
//to get a Response object back


public class APITest 
{
	
	@Test(priority = 3)
	public void getApi()
	{
		given().
		when().
		   get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		  //statusCode(200);
		assertThat().
        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
  
	
	@Test(priority = 2)
	public void getCurrentTime()
	{
		String code = "98001";
		
		RestAssured.baseURI="https://stage-commandcenter2.globaltranz.com/Hermes/API/Utilities/Location/";	
	   Response response =
		given().
		     auth().preemptive().basic("SmoketestDOQA", "QAsmoketest!0").
	         pathParam("Zipcode",code).
	         
		when().
		  get("{Zipcode}/CurrentTime").
		  
		then().
		  assertThat().
		  statusCode(200).
		  
		 and().
		   extract().response();
		
		System.out.println("Response Body is: " + response.asString());
		
	}	
	
	@Test(priority=1)
	public void postAPI_SupportRoles() throws Exception 
	{
		
		String Url = parseURL.getProtocol() + "://" + parseURL.getHost() + "/hermes/api/UserManagement";
	    System.out.println("The url is : " + Url);
		 
		Map<String,Object> payload = new HashMap<String, Object>();
		payload.put("ContactTypeId",9);
		payload.put("ContactId",581876);
		payload.put("ContactParentId",2);
		
		payload.put("EntityId",1317);
		payload.put("EntityTypeId",5);
		payload.put("EntityParentId",1317);		
		
		RestAssured.baseURI=Url;
		
		Response response=
		given().
				contentType("application/json; charset=UTF-16").
				auth().preemptive().basic("SmoketestDOQA", "QAsmoketest!0").
				body(payload).
		
		when().
				post("/eligiblesupportroles").
				
		then().
				contentType("application/json; charset=UTF-16").
				extract().response();
		
		response.body().prettyPrint();
		
		//System.out.println("Post Response Body is: " + response.body().prettyPrint());	
				
		//write to a File
	      FileWriter file = new FileWriter("APIResponse.json"); 
	      file.write(response.asString()); 
	      
	       
	     file.flush(); 
	     file.close(); 
	     
    
	    


}
}
