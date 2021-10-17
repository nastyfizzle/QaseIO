package tests;

import org.testng.annotations.Test;

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
