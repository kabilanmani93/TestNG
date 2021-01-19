package com.RolesandSection;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class Login {
	
	SessionFilter sessionFilter = new SessionFilter();
	
	private class SessionData
	{
		private String csrf;
	    private String session;
	    
	    public SessionData(String header, String sessionId)
	    {
			// TODO Auto-generated constructor stub
	    	
	    	this.csrf = header; 
	        this.session = sessionId;
		}
	    
	 // getter method for name 
	    public String getCsrf() 
	    { 
	        return csrf; 
	    } 
	  
	    // getter method for id 
	    public String getSessionId() 
	    { 
	        return session; 
	    } 
		
	    
	    
	}
	
	
	protected SessionData login(String username, String password) {
		
        Response getLoginResponse =
            given().
                filter(sessionFilter).
            when().
                get().
            then().
                extract().response();
        //@formatter:on

        String token = getLoginResponse.getCookie("XSRF-TOKEN");

        System.out.println("the token from getloginresponse is :" + token);


        //@formatter:off
        /* given().log().all().
            filter(sessionFilter).
            param("username", username).
            param("password", password).
            param("_csrf", token).
        when().
            post("/authentication");*/
        
        Response tokenResponse =

           given().log().all().
           		auth().form(username,password,new FormAuthConfig(".", "j_username", "j_password").withLoggingEnabled()).
           		header("X-XSRF-TOKEN",token).
                filter(sessionFilter).
            when().
                post("/api/authentication").
            then().log().all().
                extract().response();

		System.out.println("the Jsession id is 2 : " + sessionFilter.getSessionId());
		String token2 = tokenResponse.getCookie("XSRF-TOKEN");
		System.out.println("the 2nd token from tokenresponse is :" + token2);
        //@formatter:on
        return new SessionData(tokenResponse.getCookie("XSRF-TOKEN"), sessionFilter.getSessionId());
    }

	
	@Test
	public void create_role() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.eshipper.com";
	    SessionData sessionData = login("admin", "admin");
	    
	    final Response response = 
	    	given().
	    		contentType("application/json; charset=UTF-16").
	            header("X-XSRF-TOKEN", sessionData.getCsrf()).
	            filter(sessionFilter).
	            body(new FileReader("JSON Files/Roles_Section/CreateRole.JSON")).
	        when().    
	        	post("/api/authority");
	    
	    response.body().prettyPrint();
	    
	    Assert.assertEquals(HttpStatus.SC_ACCEPTED, response.getStatusCode());
	}
}
