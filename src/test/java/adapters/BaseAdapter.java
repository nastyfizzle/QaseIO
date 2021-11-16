package adapters;


import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://api.qase.io/";
    String TOKEN = "df33f1280430de441653ec6069038bfc68a58c1d";

    @Step("Perform the post method and validate status code: '{statusCode}'")
    public void post(String body, String uri, int expectedStatusCode) {
            given().
                    header("Content-Type", "application/json").
                    header("Token", TOKEN).
                    body(body)
                    .log().all().
            when().
                    post(BASE_URL + uri).
            then().
                    log().all().
                    statusCode(expectedStatusCode);
    }

    @Step("Perform the delete method and validate status code: '{statusCode}'")
    public void delete(String uri) {
            given().
                    header("Content-Type", "application/json").
                    header("Token", TOKEN).
            when().
                    delete(BASE_URL + uri).
            then().
                    log().all();
    }

    @Step("Perform the get method and validate status code: '{statusCode}'")
    public String get(String uri, int expectedStatusCode) {
        return
                given().
                        header("Content-Type", "application/json").
                        header("Token", TOKEN).
                        log().all().
                when().
                        get(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(expectedStatusCode).
                        extract().body().asString();
    }

    @Step("Perform the patch method and validate status code: '{statusCode}'")
    public String patch(String body, String uri, int expectedStatusCode) {
            given().
                    header("Content-Type", "application/json").
                    header("Token", TOKEN).
                    body(body).
                    log().all().
            when().
                    patch(BASE_URL + uri).
            then().
                    log().all().
                    statusCode(expectedStatusCode);
        return body;
    }

//    @Step("Validate that reposnse status in JSON is TRUE")
//    public BaseAdapter validateTrueStatus(Response response) {
//        assertTrue(response.jsonPath().getBoolean("status"));
//        return this;
//    }

}
