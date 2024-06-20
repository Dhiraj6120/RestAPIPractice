package macros;

import io.restassured.path.json.JsonPath;

public class rawToJson {
    public static JsonPath toJSON(String response){
        JsonPath jp;
        jp = new JsonPath(response);
        return jp;
    }
}
