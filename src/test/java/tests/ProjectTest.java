package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;

public class ProjectTest extends BaseTest {

    @Test(description = "Check creating a project with fields filled in with valid values")
    public void projectShouldBeCreated() {
        new LoginPage()
                .open()
                .isOpened()
                .validLogin(user, password)
                .clickOnCreateNewProjectButton()
                .isOpened()
                .fillInFields("CircleCI", "QIO", "Any test data here", "Public", "")
                .clickOnCreateProjectButton();
        new ProjectsPage()
                .open()
                .isProjectCreated("CircleCI");
//        Assert.assertEquals(ProjectDetailsPage.getProjectName(), "CircleCI",
//                "Project wasn't created or it has wrong name");
    }

    @Test(description = "Check the editing a title of the project")
    public void titleOfTheProjectShouldBeEdited() {
        new LoginPage()
                .open()
                .isOpened()
                .validLogin(user, password)
                .clickOnSettingsOption("CircleCI")
                .editProjectTitle("CircleCI_Test")
                .clickOnUpdate()
                .isProjectTitleUpdated("CircleCI_Test");
    }

    @Test(description = "Check the deleting a project")
    public void projectShouldBeDeleted() {
        new LoginPage()
                .open()
                .isOpened()
                .validLogin(user, password)
                .clickOnDeleteProjectOption("CircleCI_Test")
                .confirmDeleting()
                .isProjectDeleted("CircleCI");
    }
}
