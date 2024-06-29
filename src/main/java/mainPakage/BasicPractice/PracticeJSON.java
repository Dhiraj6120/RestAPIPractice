package mainPakage.BasicPractice;

import io.restassured.path.json.JsonPath;
import macros.getBody;
import macros.rawToJson;
import org.testng.annotations.Test;

public class PracticeJSON extends rawToJson {
    @Test
    public void printJson(){

        JsonPath js;
        js = toJSON(getBody.getBookDetails());

        //Total mainAPIContract in Json
        int totalCourses = js.getInt("Courses.size()");
        System.out.println("Total mainAPIContract: " + totalCourses);

        //Total purchase amount
        int expectedTotalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total Amount: " + expectedTotalPurchaseAmount);

        String tilteOFFstbook = js.getString("Courses[0].title");

        System.out.println("Title of fst course: " + tilteOFFstbook);

        int actualTotalPurchaseAmount = 0;

        for(int i = 0; i<totalCourses; i++){
            String title = js.getString("Courses[" + i + "].title");
            actualTotalPurchaseAmount += (js.getInt("Courses[" + i + "].price")) * (js.getInt("Courses[" + i + "].copies"));
        if(title.equals("RPA")) {
                int bookPrice = js.getInt("Courses[" + i + "].price");
                int copies = js.getInt("Courses[" + i + "].copies");

                System.out.println("We have " + title + " at price of " + bookPrice + " with total copies of " + copies);

            }
        }

        if (actualTotalPurchaseAmount == expectedTotalPurchaseAmount){
            System.out.println("Test case is passed");
        }
        else {
            System.out.println("Test case is failed");
        }

    }
}
