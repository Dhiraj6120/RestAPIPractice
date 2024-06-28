package mainPakage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import macros.SaveAsJson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static macros.rawToJson.toJSON;

public class OAuth {

    String access_token = "";
    @Test
    public void createAccessTokenforOAuth(){
        String tokenResponse = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type:", "client_credentials")
                .formParam("scope", "trust")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        JsonPath jp = toJSON(tokenResponse);
        access_token = jp.getString("access_token");

        System.out.println(access_token);
    }

    @Test
    public void getResponse(){
        RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/getCourseDetails";
        String getCourses = given().queryParam("access_token", access_token)
                .when().get()
                .then().log().all().extract().response().asString();


        SaveAsJson.StringToJson(getCourses);
    }

}
