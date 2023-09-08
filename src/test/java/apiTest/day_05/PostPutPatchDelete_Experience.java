package apiTest.day_05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class PostPutPatchDelete_Experience {

    Response response;
    int experienceId;

    String email = "jack@gmail.com";
    String password = "Jack12345";


    @BeforeClass
    public void setUpClass() {
        baseURI = "https://www.krafttechexlab.com/sw/api/v1";
    }

    /**
     * Request ne içermelidir?
     * HTTP method (Get,Post,Put,Patch,Delete ...)
     * Base URL
     * EndPoint
     * Headers (Gerekiyorsa)
     * Parameters (Path veya Querry) (Gerekiyorsa)
     * Body (Post, Put, Patch için zorunludur)
     * Token-Authorization (gerekiyorsa)
     */
    @Test (priority = 0 )
    public void addNewExperience() {

        String body = "{\n" +
                "  \"job\": \"PHP Developer\",\n" +
                "  \"company\": \"Kraft Techex\",\n" +
                "  \"location\": \"Turkey\",\n" +
                "  \"fromdate\": \"2020-11-11\",\n" +
                "  \"todate\": \"2022-11-11\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"Description\"\n" +
                "}";

         response = RestAssured.given().contentType(ContentType.JSON)
                .headers("token", Authorization.getToken(email, password))
                .body(body)
                .post("/experience/add")
                .prettyPeek();
        Assert.assertEquals(response.statusCode(), 200);
        experienceId=response.path("id");

    }

    @Test (priority = 1)
    public void updateExperienceWithPut() {

        String body = "{\n" +
                "  \"job\": \"Java Developer\",\n" +
                "  \"company\": \"Kraft Techex\",\n" +
                "  \"location\": \"Turkey\",\n" +
                "  \"fromdate\": \"2020-11-11\",\n" +
                "  \"todate\": \"2022-11-11\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"Description\"\n" +
                "}";

        String jsonBody= """
                {
                  "job": "Senior Developer",
                  "company": "Kraft Techex",
                  "location": "Germany",
                  "fromdate": "2023-01-02",
                  "todate": "2023-09-01",
                  "current": "false",
                  "description": "Description"
                }
                """;

         response = RestAssured.given().contentType(ContentType.JSON)
                .headers("token", Authorization.getToken(email, password))
                .body(jsonBody)
                .queryParam("id",experienceId)
                .when()
                .put("/experience/updateput")
                .prettyPeek();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void deleteExperience(){
        response = RestAssured.given().accept(ContentType.JSON)
                .headers("token",Authorization.getToken(email,password))
                .pathParam("id",experienceId)
                .when()
                .delete("/experience/delete/{id}")
                .prettyPeek();
        Assert.assertEquals(response.statusCode(),200);
    }

}
