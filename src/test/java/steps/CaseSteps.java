package steps;

import io.qameta.allure.Step;
import models.TestCase;
import pages.NewCasePage;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;

public class CaseSteps {

    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    NewCasePage newCasePage;

    public CaseSteps() {
        this.projectsPage = new ProjectsPage();
        this.projectDetailsPage = new ProjectDetailsPage();
        this.newCasePage = new NewCasePage();
    }

    @Step("Create new test case")
    public void createTestCase(TestCase testCase) {
        projectsPage
                .open("TP")
                .clickOnCreateNewCaseButton();
        newCasePage
                .isOpened()
                .fillInMandatoryFields(testCase);
    }

}
