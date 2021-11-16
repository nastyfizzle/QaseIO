package tests;

import models.Project;
import models.Suite;
import models.api.Response;
import org.testng.annotations.Test;

public class SuiteApiTest extends BaseTest{

    @Test
    public void createNewSuiteTest() {
        Project project = Project.builder()
                .title("Project with suite")
                .code("PWS")
                .build();
        Suite suite = Suite.builder()
                .title("Suite name")
                .description("Any test description")
                .parentId(1)
                .build();
        projectsAdapter.createProject(project);
        suiteAdapter.createSuite(suite, project.getCode());
        Response<Suite> suiteResponse = suiteAdapter.getSuite(project.getCode(), 1);
        System.out.println(suiteResponse);
        suiteAdapter.deleteSuite(project.getCode(), 1);
        projectsAdapter.deleteProject(project.getCode());
    }
}
