package macros;

import org.json.JSONObject;

import java.io.FileWriter;

public class SaveAsJson {
    public static void StringToJson(String stringResponse){
        JSONObject jsonObject = new JSONObject(stringResponse);
        String filePath = System.getProperty("user.dir") + "/src/main/java/Resources/output.json";
        try (FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(jsonObject.toString(4));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
