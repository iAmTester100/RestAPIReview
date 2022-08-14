package test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class OauthTest {

    public static void main(String[] args) throws InterruptedException {


/*        System.setProperty("webdriver.chrome.driver","/Users/AbhiBhatt/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?scope" +
                "=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fgmail.modify&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fauth&" +
                "client_id=532618568160-t8043mcfebav92pd25sus1g6ifof25em.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2F" +
                "oauth.pstmn.io%2Fv1%2Fcallback&state=verify&flowName=GeneralOAuthFlow");

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("js5015206@gmail.com");
        driver.findElement(By.cssSelector(".VfPpkd-vQzf8d")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Hello1000!");
        driver.findElement(By.cssSelector(".VfPpkd-vQzf8d")).sendKeys(Keys.ENTER);*/
        //Thread.sleep(4000);

        String url="https://oauth.pstmn.io/v1/callback?state=verify&code=4/0AdQt8qjRxJKy3AhCHG4gb0cOjbv42RCxLxLIBjdqImpNWsgxf_" +
                "MVZZyW03X6u70tHwYnZw&scope=https://www.googleapis.com/auth/gmail.modify";

        String partialCode= url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);

        String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code",code)
          .queryParam("code","")
               .queryParam("client_id","532618568160-t8043mcfebav92pd25sus1g6ifof25em.apps.googleusercontent.com")
               .queryParam("client_secret","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")
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
