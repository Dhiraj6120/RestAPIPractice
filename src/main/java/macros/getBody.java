package macros;

public class getBody {
    public static String getPostBody(){
        return """
                {
                  "location": {
                    "lat": -38.383494,
                    "lng": 33.427362
                  },
                  "accuracy": 50,
                  "name": "Frontline house",
                  "phone_number": "(+91) 983 893 3937",
                  "address": "830-862 w 33rd street, Chicago",
                  "types": [
                    "shoe park",
                    "shop"
                  ],
                  "website": "http://google.com",
                  "language": "French-IN"
                }
                """;
    }

    public static String getPutBody(String placeId){
        return "{\n" +
                "\"place_id\":\""+ placeId +"\",\n" +
                "\"address\":\"570 10th ave, New York\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
