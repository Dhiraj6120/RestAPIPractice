package mainPakage;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static macros.getBody.*;
import static macros.rawToJson.*;
import static io.restassured.RestAssured.given;

public class GooglePlaceAPI {
    @Test(dataProvider = "getAddressDaaaata")
    public void googleAPIs(String s1, String s2){
        //TODO: Create Method for CRUD operation

        //given: All input details
        //when: Submit the API -resource, http method
        //then:
        String placeID;
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(getPostBody(s1, s2))
                .when().post("/maps/api/place/add/json").
                then().log().all().assertThat().extract().response().asString();

        placeID = toJSON(response).getString("place_id");

//        """This One for the Post Request"""
        // given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
        //         .when().get("/maps/api/place/get/json")
        //         .then().log().all();

        System.out.println("place ID: " + placeID);


        given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
                .header("Content-Type","application/json")
                .body(getPutBody(placeID))
                .when().put("/maps/api/place/update/json")
                        .then().log().all().assertThat().statusCode(200);

        given().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(getDeletePlaceBody(placeID))
                .when().delete("/maps/api/place/delete/json")
                .then().log().all().assertThat().statusCode(200);


        // given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
        //         .when().get("/maps/api/place/get/json")
        //         .then().log().all().body("address", equalTo("570 10th ave, New York"));


    }

    @DataProvider(name = "getAddressDaaaata")
    public Object[][] getAddressData(){
        return new Object[][] {{"570 10th ave", "1234564"}, {"830-862 w 33rd street, Chicago", "98776553"}};
    }
}
