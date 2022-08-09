package test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI="https://reqres.in/";

     String realName = "Abhishek";

      String response = given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.addUser()).when().post("api/users")
                .then().assertThat().statusCode(201).body("name",equalTo("Abhishek")).extract().response().asString();

        System.out.println(response);

        JsonPath js = ReusableMethods.rawToJson(response);
        String responseName = js.getString("name");
        System.out.println(response);

        Assert.assertEquals(realName,responseName);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .when().get("api/user/2")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();



     String updatedResponse=   given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.updateUser()).when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200).body("name",equalTo("Ajay")).extract().response().asString();

        System.out.println(updatedResponse);

        JsonPath json = new JsonPath(updatedResponse);
        String newName = json.getString("name");
        System.out.println(newName);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.deleteUser()).when().delete("api/users/2")
                .then().log().all().assertThat().statusCode(204);


    }
}
