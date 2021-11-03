package adapters;

import com.google.gson.Gson;
import models.Project;

import static io.restassured.RestAssured.given;

public class ProjectsAdapter extends BaseAdapter {

    public void create(Project project) {
        post(new Gson().toJson(project), "v1/project");
    }

    public void delete(String code) {
        given().
                header("Content-Type", "application/json").
                //auth().basic("USERNAME", "PASSWORD").
                header("Token", "df33f1280430de441653ec6069038bfc68a58c1d").
        when().
                delete("https://api.qase.io/v1/project/" + code).
        then().
                log().all().
                statusCode(200);
    }



}


// df33f1280430de441653ec6069038bfc68a58c1d
//{
//    "title": "API project",
//    "code": "API"
//}
// POST https://api.qase.io/v1/project
//https://api.qase.io/v1/project/{code}