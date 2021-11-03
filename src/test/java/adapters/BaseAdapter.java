package adapters;

import com.google.gson.Gson;
import models.Project;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://api.qase.io/";

    public void post(String body, String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "df33f1280430de441653ec6069038bfc68a58c1d").
                body(body).
        when().
                post(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

}
