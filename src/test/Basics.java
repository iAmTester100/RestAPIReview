package test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI="https://reqres.in/";

      String response = given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.addUser()).when().post("api/users")
                .then().assertThat().statusCode(201).body("name",equalTo("Abhishek")).extract().response().asString();

        System.out.println(response);

        JsonPath json = new JsonPath(response);
        String name = json.getString("name");
        System.out.println(name);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .when().get("api/user/2")
                .then().log().all().assertThat().statusCode(200);

        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.updateUser()).when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body(payload.deleteUser()).when().delete("api/users/2")
                .then().log().all().assertThat().statusCode(204);


    }
}
