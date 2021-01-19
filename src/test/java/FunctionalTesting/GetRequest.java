package FunctionalTesting;

import com.aventstack.extentreports.Status;
import factory.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest extends TestBase {

    @Test
    public void getRequestAutomation(){


        RestAssured.baseURI ="https://reqres.in/api/users";

        Response response = given().param("page","2").when().get();

        System.out.println("The response is" + response.prettyPrint());
        System.out.println("The Status code is" + response.getStatusCode());
        System.out.println("The Cookie is" + response.getCookies());
        System.out.println("The Time is" + response.getTime());



//        RestAssured.given()
//                     .param("page","2")
//                .when()
        //                .get()
//                .then()
        //                .assertThat()
        //                .log().all()
        //                .statusCode(200);
}
}
