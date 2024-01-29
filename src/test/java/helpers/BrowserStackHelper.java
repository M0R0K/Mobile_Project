package helpers;


import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStackHelper {

    public static String getVideoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("konstantinponoma1", "Xm7oxCr3o3urzg9XpW6y")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}