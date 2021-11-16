package tests;

import lombok.extern.log4j.Log4j2;
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
}
