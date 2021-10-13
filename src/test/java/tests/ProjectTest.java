package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;

public class ProjectTest extends BaseTest{

    @Test
    public void projectShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, password);
        new ProjectsPage()
                .clickOnCreateNewProjectButton();
        new NewProjectPage()
                .fillInFields("CircleCI", "QIO", "Any test data here", "Public", "")
                .clickOnCreateProjectButton();
        Assert.assertEquals(ProjectDetailsPage.getTestCaseName(), "CircleCI",
                "Project wasn't created or it has wrong name");
    }
}
