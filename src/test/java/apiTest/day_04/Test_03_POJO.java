package apiTest.day_04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoTemplates.Education;
import pojoTemplates.Experience;
import pojoTemplates.KraftUser;

import java.util.List;

import static io.restassured.RestAssured.baseURI;

public class Test_03_POJO {
    @BeforeClass
    public void setUpClass(){
        baseURI="https://www.krafttechexlab.com/sw/api/v1";
    }

    @Test
    public void pojoTestKraft(){
        /**
         * TASK
         * base url = https://www.krafttechexlab.com/sw/api/v1
         * end point /allusers/getbyid/{id}
         * id parameter value is 62
         * send the GET request
         * then status code should be 200
         * get all data into a custom class (POJO)
         */

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 62)
                .when()
                .get("/allusers/getbyid/{id}");
        Assert.assertEquals(response.statusCode(),200);

        KraftUser[] kraftUsers = response.as(KraftUser[].class);
        Integer id = kraftUsers[0].getId();
        Assert.assertEquals(id,62);

        System.out.println("kraftUsers[0].getName() = " + kraftUsers[0].getName());

        // skills lerden 2. sini alalım
        List<String> skills = kraftUsers[0].getSkills();
        String skills1 = skills.get(1);
        System.out.println("skills1 = " + skills1);

        // 3. educationın school bilgisini alalım
        List<Education> education = kraftUsers[0].getEducation();
        String school = education.get(2).getSchool();
        System.out.println("school = " + school);

        // 2. experience companysini alalım
        List<Experience> experience = kraftUsers[0].getExperience();
        String company = experience.get(1).getCompany();
        System.out.println("company = " + company);

    }
}
