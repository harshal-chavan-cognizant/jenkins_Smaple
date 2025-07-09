package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.testng.annotations.Test;

public class AppTest{

    @Test
    public void sampleApiTest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.given()
                .when()
                .get("/posts/1");

        response.then().assertThat().statusCode(200);

        System.out.println("Response code : " + response.getStatusCode());
        System.out.println("Response body : " + response.getBody().asPrettyString());
    }

}
