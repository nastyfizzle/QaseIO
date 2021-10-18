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

    @Step("Create new test case with filled in title and dropdowns")
    public CaseSteps createTestCase(String projectCode, String projectName, TestCase testCase) {
        projectsPage
                .open(projectCode)
                .isOpened(projectName)
                .clickOnCaseButton()
                .isOpened()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton();
        return this;
    }

    @Step("Update test case title with the new one")
    public CaseSteps updateTestCaseTitle(String projectCode, String projectName, TestCase testCase) {
        projectsPage
                .open(projectCode)
                .isOpened(projectName)
                .clickOnEditTestCaseButton(testCase.getTitle())
                .updateMandatoryFields(testCase)
                .clickOnSaveButton();
        return this;
    }

    @Step("Delete test case")
    public CaseSteps deleteTestCase(String projectCode, String projectName, TestCase testCase) {
        projectsPage
                .open(projectCode)
                .isOpened(projectName)
                .clickOnTestCaseName(testCase.getTitle())
                .clickOnDeleteTestCaseButton(testCase.getTitle())
                .confirmDeletingTestCase();
        return this;
    }

    @Step("Validate the name of created test case is displayed in the list of test cases")
    public CaseSteps validateTestCaseCreated(TestCase testCase) {
        projectDetailsPage
                .open("TP")
                .isTestCaseCreated(testCase.getTitle());
        return this;
    }

    @Step("Validate the name of test case is displayed with updated value in the list of test cases")
    public CaseSteps validateTestCaseUpdated(TestCase testCase) {
        projectDetailsPage
                .open("TP")
                .isTestCaseUpdated(testCase.getTitle());
        return this;
    }

    @Step("Validate the name of deleted test case isn't displayed in the list of test cases")
    public CaseSteps validateTestCaseDeleted(TestCase testCase) {
        projectDetailsPage
                .open("TP")
                .isTestCaseDeleted(testCase.getTitle());
        return this;
    }
}
