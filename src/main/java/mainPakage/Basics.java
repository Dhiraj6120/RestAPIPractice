package mainPakage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.Dictionary;
import java.util.Map;

import static Data.getBody.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args){
        //TODO: Create Method for CRUD operation

        //given: All input details
        //when: Submit the API -resource, http method
        //then:
        String placeID = "";
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(getPostBody())
                .when().post("/maps/api/place/add/json").
                then().log().all().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        placeID = jsonPath.getString("place_id");

        System.out.println("Post Post");

        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
                .when().get("/maps/api/place/get/json")
                .then().log().all();

        System.out.println("Post Get 1");

//
        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
                .header("Content-Type","application/json")
                .body(getPutBody(placeID))
                .when().put("/maps/api/place/update/json")
                        .then().log().all().assertThat().statusCode(200);

        System.out.println("Post Put");
//
        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
                .when().get("/maps/api/place/get/json")
                .then().log().all().body("address", equalTo("570 10th ave, New York"));

        System.out.println("Post Get 2");


    }
}
