package test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class OauthTest {

    public static void main(String[] args) throws InterruptedException {


        String url="https://oauth.pstmn.io/v1/callback?state=verify&code=4/0AdQt8qjRxJKy3AhCHG4gb0cOjbv42RCxLxLIBjdqImpNWsgxf_" +
                "MVZZyW03X6u70tHwYnZw&scope=https://www.googleapis.com/auth/gmail.modify";

        String partialCode= url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);

        String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code",code)
          .queryParam("code","")
               .queryParam("client_id","532618568160-t8043mcfebav92pd25sus1g6ifof25em.apps.googleusercontent.com")
               .queryParam("client_secret","XXXXXXXXXXXXXXXXXXXXXXXXX") // have put as such for security reasons
               .queryParam("redirect_uri","https://oauth.pstmn.io/v1/callback")
               .queryParam("grant_type","authorization_code")
               .when().log().all().post("https://accounts.google.com/o/oauth2/token").asString();

        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken= js.getString("access_token");
        System.out.println(accessToken);


        String response=  given().queryParam("access_token",accessToken)
                .when().log().all().get("https://oauth.pstmn.io/v1/callback").asString();

        System.out.println(response);

    }
}
