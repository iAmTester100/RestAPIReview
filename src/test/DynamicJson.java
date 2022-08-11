package test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(dataProvider="UserData")
    public void addUser(String name, String position){

        RestAssured.baseURI="https://reqres.in/";

        String response = given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.addUserDynamic(name,position)).when().post("api/users")
                .then().assertThat().statusCode(201).extract().response().asString();

       JsonPath js = ReusableMethods.rawToJson(response);
       String id = js.get("id");
        System.out.println(id);

    }
    @DataProvider(name="UserData")

    public Object[] getData(){

        return new Object[][]{{"John", "Programmer"},{"Tony","Dev-Ops"},{"Sally","Solutions Architect"}};

    }
}
