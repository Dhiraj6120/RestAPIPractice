package seleniumWithAPI;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withNoArgs;

public class OAuth2 {
    @Test
    public void OAUth(){

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/o/oauth2/v2/auth?auth_url=https://accounts.google.com/o/oauth2/v2/auth&state=asdasd&redirect_uri=https://rahulshettyacademy.com/getCourse.php&response_type=code&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/userinfo.email");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("asdasd");
        String res2 = given().queryParam("code", "")
                .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParam("redirect_uri", "")
                .queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("grant_type", "authorization_code")
                        .when().post("https://www.googleapis.com/oauth2/v4/token")
                        .then().extract().response().asString();

        JsonPath js = new JsonPath(res2);
        String access_token = js.getString("access_token");

        given().queryParam("access_token", access_token)
                .when().get("https://rahulshettyacademy.com/getCourse.php")
                .then().extract().asString();

        driver.quit();
    }

}
