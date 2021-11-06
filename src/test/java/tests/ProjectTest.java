package tests;

import adapters.BaseAdapter;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.testng.annotations.Test;

@Log4j2
public class ProjectTest extends BaseTest {

    @Test(description = "Check creating/updating/deleting a project")
    public void projectShouldBeCRUD() {
        loginSteps
                .login(user, password);
        projectSteps
                .createProject("CircleCI", "QIO", "Any test data here", "Public", "")
                .validateProjectCreated("CircleCI")
                .updateProject("CircleCI", "CircleCI TEST")
                .validateProjectUpdated("CircleCI TEST")
                .deleteProject("CircleCI TEST")
                .validateProjectDeleted("CircleCI TEST");
    }

    @Test
    public void create() {
        Project project = Project.builder()
                .title("NEW NEW NEW")
                .code("NEW")
                .build();
        projectsAdapter.createProject(project);
        loginSteps
                .login(user, password);
        projectSteps.validateProjectCreated("NEW NEW NEW");
        projectsAdapter.delete("NEW");
    }

    @Test
    public void get() {
        Project project = Project.builder()
                .title("NEW NEW NEW")
                .code("NEW")
                .build();
        projectsAdapter.createProject(project);
        Project actualProject = projectsAdapter.getProject(project.getCode());
        System.out.println(actualProject);
        projectsAdapter.delete(project.getCode());
    }

    @Test
    public void createWithoutMandatoryFields() {
        Project project = Project.builder()
//                .title("NEW NEW NEW")
//                .code("NEW")
                .build();
        new BaseAdapter().post(new Gson().toJson(project), "v1/project", 422);
    }
}
