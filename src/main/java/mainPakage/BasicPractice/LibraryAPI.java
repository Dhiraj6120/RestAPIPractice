package mainPakage.BasicPractice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import macros.getBody;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static macros.getBody.deleteBook;
import static macros.rawToJson.toJSON;

public class LibraryAPI {
    @Test(dataProvider = "getData")
    public void libraryAPIPractice(String data1, String data2){
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse = given().log().all().header("Content-Type","application/json")
                .body(getBody.addBookBody(data1, data2))
                .when().post("Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = toJSON(addBookResponse);

        String bookId = js.getString("ID");

        System.out.println("<<<<<<<<<Book IDs" + bookId);
        System.out.println("Get Book Details");

        given().queryParam("ID", bookId)
                .when().get("Library/GetBook.php")
                .then().log().all().assertThat().statusCode(200);
//

        System.out.println("Delete the added book");


        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");



    }


    @DataProvider(name = "getData")
    public Object[][] getDaa(){
        return new Object[][] {{"asda", "1132"}, {"awsda", "1142"}, {"asdqa", "1152"}, {"aseda", "1162"}};
    }
}
