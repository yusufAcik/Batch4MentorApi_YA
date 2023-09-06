package apiTest.day_04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoTemplates.GoRestUser;

import static io.restassured.RestAssured.baseURI;

public class Test_02_POJO {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://gorest.co.in/public/v2";
    }
    @Test
    public void goRestPojoTest(){
        /**
         //TASK
         //base url = https://gorest.co.in
         //end point = /public/v2/users
         //path parameter = {id} --> 5114448
         //send a get request with the above credentials
         //parse to Json object to pojo (custom java class)
         //verify that the body below


         {
         "id": 5114448,
         "name": "Krishna Bhat",
         "email": "bhat_krishna@murazik-moen.test",
         "gender": "male",
         "status": "inactive"
         }  */

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 5114448)
                .when()
                .get("/users/{id}");
        Assert.assertEquals(response.statusCode(),200);

        GoRestUser goRestUser = response.as(GoRestUser.class);
        System.out.println("goRestUser.getEmail() = " + goRestUser.getEmail());
        Assert.assertEquals(goRestUser.getId(),5114448);

        System.out.println("goRestUser = " + goRestUser.toString());
        System.out.println("goRestUser = " + goRestUser);
        //class ta toString metodu varsa burada yazdırırken toString dememize gerek yok otomatik yazdırır

    }
}
