package tests;

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
                .login("nastasv691@gmail.com", "Nastya123!");
        new ProjectsPage()
                .clickOnCreateNewProjectButton();
        new NewProjectPage()
                .fillInFields("QaseIO", "QIO", "Any test data here", "Public", "")
                .clickOnCreateProjectButton();
        new ProjectDetailsPage()
                .isOpened();
    }
}
