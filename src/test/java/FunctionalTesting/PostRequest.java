package FunctionalTesting;

import APITesting.parseURL;
import factory.DataProviderFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest {

    @Test
    public void postRequest() throws Exception {
        String Url = parseURL.getProtocol(DataProviderFactory.getConfig().getConfigPro().getProperty("FunDooURL"))
                + "://" + parseURL.getHost(DataProviderFactory.getConfig().getFunDooUrl());
        System.out.println("The url is : " + Url);

        Map<String,Object> payload = new HashMap<String, Object>();
        payload.put("name","Kabilan");
        payload.put("job","SDET");


        RestAssured.baseURI=Url;

        Response response;
        response =
                given()
                    .body(payload)
                .when()
                    .post("/api/users");
//                .then()
//                    .contentType("application/json; charset=UTF-16").
//                    extract().response();

        response.prettyPrint();

    }
}
