package apiTest.day_05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class Authorization {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://www.krafttechexlab.com/sw/api/v1";
    }

    @Test
    public void tokenTest(){
        String email="jack@gmail.com";
        String password="Jack12345";

        Response response = RestAssured.given().accept(ContentType.MULTIPART)
                .formParam("email", email)
                .formParam("password", password)
                .when().log().all()
                .post("/allusers/login")
                .prettyPeek();

        Assert.assertEquals(response.statusCode(),200);
    }
}
