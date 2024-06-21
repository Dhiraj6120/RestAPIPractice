package mainPakage;

import io.restassured.path.json.JsonPath;
import macros.getBody;
import macros.rawToJson;
import org.testng.annotations.Test;

public class PracticeJSON extends rawToJson {
    @Test
    public void printJson(){

        JsonPath js;
        js = toJSON(getBody.getBookDetails());

        //Total Courses in Json
        int totalCourses = js.getInt("courses.size()");
        System.out.println("Total Courses: " + totalCourses);

        //Total purchase amount
        int expectedTotalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total Amount: " + expectedTotalPurchaseAmount);

        String tilteOFFstbook = js.getString("courses[0].title");

        System.out.println("Title of fst course: " + tilteOFFstbook);

        int actualTotalPurchaseAmount = 0;

        for(int i = 0; i<totalCourses; i++){
            String title = js.getString("courses[" + i + "].title");
            actualTotalPurchaseAmount += (js.getInt("courses[" + i + "].price")) * (js.getInt("courses[" + i + "].copies"));
        if(title.equals("RPA")) {
                int bookPrice = js.getInt("courses[" + i + "].price");
                int copies = js.getInt("courses[" + i + "].copies");

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
