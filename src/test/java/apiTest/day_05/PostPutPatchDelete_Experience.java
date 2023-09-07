package apiTest.day_05;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class PostPutPatchDelete_Experience {

    @BeforeClass
    public void setUpClass(){
        baseURI="https://www.krafttechexlab.com/sw/api/v1";
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
    @Test
    public void addNewExperience(){

    }
}
