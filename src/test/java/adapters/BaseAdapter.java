package adapters;


import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://api.qase.io/";

    public void post(String body, String uri, int expectedStatusCode) {
        given().
                header("Content-Type", "application/json").
                header("Token", "df33f1280430de441653ec6069038bfc68a58c1d").
                body(body).
        when().
                post(BASE_URL + uri).
        then().
                log().all().
                statusCode(expectedStatusCode);
    }

    public void delete(String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "df33f1280430de441653ec6069038bfc68a58c1d").
        when().
                delete(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public String get(String uri) {
        String body =
                given().
                        header("Content-Type", "application/json").
                        header("Token", "df33f1280430de441653ec6069038bfc68a58c1d").
                when().
                        get(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(200)
                        .extract().body().asString();
        return body;
    }

}
