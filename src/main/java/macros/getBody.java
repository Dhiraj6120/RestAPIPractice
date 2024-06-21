package macros;

public class getBody {
    public static String getPostBody(String s1, String s2){
        return "{\n" +
                "                  \"location\": {\n" +
                "                    \"lat\": -38.383494,\n" +
                "                    \"lng\": 33.427362\n" +
                "                  },\n" +
                "                  \"accuracy\": 50,\n" +
                "                  \"name\": \""+s1+"\",\n" +
                "                  \"phone_number\": \""+s2+"\",\n" +
                "                  \"address\": \"830-862 w 33rd street, Chicago\",\n" +
                "                  \"types\": [\n" +
                "                    \"shoe park\",\n" +
                "                    \"shop\"\n" +
                "                  ],\n" +
                "                  \"website\": \"http://google.com\",\n" +
                "                  \"language\": \"French-IN\"\n" +
                "                }";
    }

    public static String getDeletePlaceBody(String placeID){
        return "{\n" +
                "    \"place_id\":\""+ placeID +"\"\n" +
                "}";
    }

    public static String getPutBody(String placeId){
        return "{\n" +
                "\"place_id\":\""+ placeId +"\",\n" +
                "\"address\":\"570 10th ave, New York\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String getBookDetails(){
        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }

    public static String addBookBody(String isbn, String aisle){
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\""+ aisle + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }

    public static String deleteBook(){
        return "{\n" +
                "\"ID\" : \"asda1122\"\n" +
                "}\n";
    }
}
