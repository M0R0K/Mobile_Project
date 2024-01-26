package helpers;


import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStackHelper {

    public static String getVideoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("konstantinponoma_D5b6GJ", "1J37VSAdXUgQadooFF4v")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}