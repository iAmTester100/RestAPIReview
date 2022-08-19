package test;

import files.ReusableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        String realName = "Abhishek";

        String response = given().log().all().header("Connection", "keep-alive").header("Content-Type", "application/json")
                .body(payload.addUser()).when().post("api/users")
                .then().assertThat().statusCode(201).body("name", equalTo("Abhishek")).extract().response().asString();

        System.out.println(response);

        JsonPath js = ReusableMethods.rawToJson(response);
        String responseName = js.getString("name");
        System.out.println(response);

        Assert.assertEquals(realName, responseName);


        GetUsers getPageList = given().log().all().header("Connection", "keep-alive").header("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
                .when().get("api/unknown").as(GetUsers.class);


        System.out.println(getPageList.getPage());
        System.out.println(getPageList.getPer_page());
        System.out.println(getPageList.getData().get(0).getColor());
        System.out.println(getPageList.getData().get(1).getId());
        System.out.println(getPageList.getSupport().getText());
        System.out.println(getPageList.getSupport().getUrl());

        List<GetData> data = getPageList.getData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equalsIgnoreCase("fuchsia rose")) {
                System.out.println(data.get(i).getYear());
            }

        }


        String [] colours = {"#98B2D1","#C74375","#BF1932","#7BC4C4","#E2583E","#53B0AE"};

        ArrayList <String> array = new ArrayList<String>();

        List<GetData> colour = getPageList.getData();
        for (int j = 0; j < colour.size(); j++) {
            array.add(data.get(j).getColor());

            }

       List<String> expectedList = Arrays.asList(colours);

        Assert.assertTrue(array.equals(expectedList));






        String updatedResponse = given().log().all().header("Connection", "keep-alive").header("Content-Type", "application/json")
                .body(payload.updateUser()).when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200).body("name", equalTo("Ajay")).extract().response().asString();

        System.out.println(updatedResponse);

        JsonPath json = new JsonPath(updatedResponse);
        String newName = json.getString("name");
        System.out.println(newName);


        given().log().all().header("Connection", "keep-alive").header("Content-Type", "application/json")
                .body(payload.deleteUser()).when().delete("api/users/2")
                .then().log().all().assertThat().statusCode(204);


    }
}
