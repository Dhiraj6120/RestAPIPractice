package mainPakage.BasicPractice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static macros.getBody.*;
import static macros.rawToJson.toJSON;

public class GooglePlaceAPIWithSpecBuilder {
    @Test(dataProvider = "getAddressDaaaata")
    public void googleAPIs(String s1, String s2){
        //TODO: Create Method for CRUD operation

        //given: All input details
        //when: Submit the API -resource, http method
        //then:
        String placeID;

        RequestSpecification reqAdd = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();

        ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();

        String response = given().spec(reqAdd)
                .body(getPostBody(s1, s2))
                .when().post("/maps/api/place/add/json").then().spec(res).extract().response().asString();

        placeID = toJSON(response).getString("place_id");

        RequestSpecification req1 = given().spec(reqAdd)
                .queryParam("place_id", placeID)
                .body(getPutBody(placeID));

        req1.when().put("/maps/api/place/update/json")
                        .then().spec(res);

        given().spec(reqAdd)
                .body(getDeletePlaceBody(placeID))
                .when().delete("/maps/api/place/delete/json")
                .then().spec(res);
    }

    @DataProvider(name = "getAddressDaaaata")
    public Object[][] getAddressData(){
        return new Object[][] {{"570 10th ave", "1234564"}, {"830-862 w 33rd street, Chicago", "98776553"}};
    }
}
