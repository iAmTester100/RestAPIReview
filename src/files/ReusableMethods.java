package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public static  JsonPath rawToJson(String response){

        JsonPath json1 = new JsonPath(response);
        return json1;
    }
}
