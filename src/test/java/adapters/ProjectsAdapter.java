package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Project;
import models.api.Response;


public class ProjectsAdapter extends BaseAdapter {

    public void createProject(Project project) {
        post(new Gson().toJson(project), "v1/project/", 200);
    }

    public void deleteProject(String code) {
        delete("v1/project" + code, 200);
    }

    public Response<Project> getProject(String code) {
        String body = get("v1/project/" + code, 200);
        return new Gson().fromJson(body, new TypeToken<Response<Project>>() {}.getType());
    }
}