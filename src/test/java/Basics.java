package test.java;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI="https://reqres.in/";

        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"Abhishek\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").when().post("api/users")
                .then().log().all().assertThat().statusCode(201).body("name",equalTo("Abhishek"));

        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .when().get("api/user/2")
                .then().log().all().assertThat().statusCode(200);

        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"Abhishek\",\n" +
                        "    \"job\": \"Lead\"\n" +
                        "}").when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"Abhishek\",\n" +
                        "    \"job\": \"Lead\"\n" +
                        "}").when().delete("api/users/2")
                .then().log().all().assertThat().statusCode(204);


        given().log().all().header("Connection","keep-alive").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"email\": \"helloworld@gmail.com\",\n" +
                        "}").when().post("api/register")
                .then().log().all().assertThat().statusCode(400);
    }
}
