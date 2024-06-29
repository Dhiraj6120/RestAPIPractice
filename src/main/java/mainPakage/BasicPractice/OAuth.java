package mainPakage.BasicPractice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import mainPakage.POJO.Api;
import mainPakage.POJO.WebAutomation;
import mainPakage.POJO.mainAPIContract;
import org.testng.annotations.Test;

import java.util.List;

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
        mainAPIContract getJ = given().queryParam("access_token", access_token)
                .when().get()
                .then().log().all().extract().response().as(mainAPIContract.class);

        List<Api> apis = getJ.getCourses().getApi();

        for(Api n : apis){
            if(n.getCourseTitle().equals("Rest Assured Automation using Java")){
                System.out.println("Price of \"Rest Assured Automation using Java\": " + n.getPrice());
                break;
            }
        }

        List<WebAutomation> webAutomations = getJ.getCourses().getWebAutomation();
        System.out.println("Prices of WebAutomation Books: ");
        for (WebAutomation webAutomation: webAutomations){
            System.out.println(webAutomation.getCourseTitle() + ": " +webAutomation.getPrice());
        }


//        SaveAsJson.StringToJson(getCourses);
    }

}
