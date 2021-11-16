package tests;

import adapters.BaseAdapter;
import com.google.gson.Gson;
import models.Project;
import models.api.Response;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseTest {

    @Test
    public void create() {
        Project project = Project.builder()
                .title("Project API test name")
                .code("RFV")
                .build();
        projectsAdapter.createProject(project);
        Response<Project> projectResponse = projectsAdapter.getProject(project.getCode());
        System.out.println(projectResponse);
        projectsAdapter.getProject("RFV");
        projectsAdapter.deleteProject("RFV");
    }

    @Test
    public void createWithoutMandatoryFields() {
        Project project = Project.builder()
                .build();
        new BaseAdapter().post(new Gson().toJson(project), "v1/project", 422);
    }
}
