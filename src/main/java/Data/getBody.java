package Data;

public class getBody {
    public static String getPostBody(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"830-862 w 33rd street, Chicago\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String getPutBody(String placeId){
        return "{\n" +
                "\"place_id\":\""+ placeId +"\",\n" +
                "\"address\":\"570 10th ave, New York\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
