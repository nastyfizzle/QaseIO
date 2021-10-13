package tests;

import models.TestCase;
import models.TestCaseFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewCasePage;
import pages.ProjectDetailsPage;

public class CaseTest extends BaseTest {

    @Test(description = "Check creating test case with filled in title and dropdowns")
    public void testCaseAllFieldsShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, password)
                .openProjectByUrl();
        new ProjectDetailsPage()
                .clickOnCreateNewCaseButton()
                .isOpened();
        TestCase testCase = TestCaseFactory.getAllFields();
        new NewCasePage()
                .fillInFields(testCase)
                .clickOnSaveButton();
        Assert.assertEquals(ProjectDetailsPage.getTestCaseName(), "Check creating a test case using automation tools",
                "Test case wasn't created or it has wrong name");
    }

    @Test(description = "Check creating test case with filled in input only")
    public void testCaseMandatoryFieldShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, password)
                .openProjectByUrl();
        new ProjectDetailsPage()
                .clickOnCaseButton()
                .isOpened();
        TestCase testCase = TestCaseFactory.getMandatoryFields();
        new NewCasePage()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton();
//        Assert.assertEquals(ProjectDetailsPage.getTestCaseName(), testCase.getTitle(),
//                "Test case wasn't created or it has wrong name");
    }

    @Test(description = "Check creating test case using [Create case] button at the bottom of the test cases list")
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, password)
                .openProjectByUrl();
        new ProjectDetailsPage()
                .clickOnCreateCaseButton()
                .isOpened();
        TestCase testCase = TestCaseFactory.getMandatoryFields();
        new NewCasePage()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton();
//        Assert.assertEquals(ProjectDetailsPage.getTestCaseName(), testCase.getTitle(),
//                "Test case wasn't created or it has wrong name");
    }

    @Test(description = "Check deleting test case")
    public void testCaseShouldBeDeleted() {
        new LoginPage()
                .open()
                .login(user, password)
                .openProjectByUrl();
        new ProjectDetailsPage()
                .clickOnCaseButton()
                .isOpened();
        TestCase testCase = TestCaseFactory.getMandatoryFields();
        new NewCasePage()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton()
                .clickOnTestCaseCheckBox()
                .confirmDeletingTestCaseOrSuite();
    }
}
