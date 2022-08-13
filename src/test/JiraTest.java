package test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraTest {

    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:8080/";

        SessionFilter session = new SessionFilter();

        String firstMessage = "Currently working on root cause analysis";

       String response= given().header("Content-Type","application/json").body("{\"username\": \"neal.bhatt100\", \"password\": \"lightweight500\"}")
               .log().all().filter(session).when()
               .post("rest/auth/1/session").then().log().all().extract().response().asString();



     String addComent= given().pathParam("id","10004").log().all().header("Content-Type","application/json").body("{\n" +
                "    \"body\": \"Currently working on root cause analysis\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}").filter(session).when().post("rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();

     JsonPath js1 = new JsonPath(addComent);
     String commendId = js1.getString("id");


        given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id","10004").header("Content-Type","multipart/form-data")
                .multiPart("file",new File("src/test/jira.text"))
                .when().post("rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);


       String details= given().filter(session).pathParam("id","10004").queryParam("fields","comment").when().get("rest/api/2/issue/{id}")
                .then().log().all().extract().response().asString();

        JsonPath js2 = new JsonPath(details);
        int count = js2.get("fields.comment.comments.size()");
        for (int i=0;i<count;i++){
        String id=js2.get("fields.comment.comments["+i+"].id").toString();
        if (id.equalsIgnoreCase(commendId)){
            String comment= js2.get("fields.comment.comments["+i+"].body").toString();
            System.out.println(comment);
            Assert.assertEquals(comment,firstMessage);
        }

        }

    }

}
