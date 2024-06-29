package mainPakage.googleAPIsPojo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoogleApiWithPogo {
    GoogleAPIPostResponse postAPI;

    RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
            .addQueryParam("key","qaclick123").build();

    @Test
    public void googleAPIPost(){
        GoogleAddPlace googleAddPlace = new GoogleAddPlace();
        googleAddPlace.setAccuracy(50);
        googleAddPlace.setAddress("570 10th ave, new york");
        googleAddPlace.setLangauge("En-Ind");
        googleAddPlace.setName("Store");
        googleAddPlace.setWebsite("https://rahulshettyacademy.com");
        googleAddPlace.setPhone_number("+91 1272318278");
        List<String> types = new ArrayList<>();
        types.add("Shoe Park");
        types.add("Mcdonalds");
        googleAddPlace.setTypes(types);
        Location loc = new Location();
        loc.setLat(12.1212);
        loc.setLng(-98.1212312);

        googleAddPlace.setLocation(loc);
        postAPI = given().spec(request)
                .body(googleAddPlace)
                .when().post("/maps/api/place/add/json")
                .then().extract().response().as(GoogleAPIPostResponse.class);
    }

    @Test
    public void googleAPIget(){
        given().spec(request).queryParam("place_id", postAPI.getPlace_id())
                .when().get("/maps/api/place/get/json")
                .then().log().all();
    }
}
