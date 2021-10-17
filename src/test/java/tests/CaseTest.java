package tests;

import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewCasePage;
import pages.ProjectDetailsPage;

public class CaseTest extends BaseTest {

    @Test(description = "Check creating a test case with filled in title and dropdowns")
    public void testCaseShouldBeCreated() {
        TestCase testCase = TestCaseFactory.getAllFields();
        new LoginPage()
                .open()
                .validLogin(user, password)
                .open("TP")
                .clickOnCaseButton()
                .isOpened()
                .fillInFields(testCase)
                .clickOnSaveButton()
                .isTestCaseCreated(testCase.getTitle());
    }

    @Test(description = "Check creating test case with filled in input only")
    public void testCaseMandatoryFieldShouldBeCreated() {
        TestCase testCase = TestCaseFactory.getMandatoryFields();
        new LoginPage()
                .open()
                .validLogin(user, password)
                .open("TP")
                .clickOnCaseButton()
                .isOpened()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton()
                .isTestCaseCreated(testCase.getTitle());
    }

    @Test(description = "Check deleting test case")
    public void testCaseShouldBeDeleted() {
        TestCase testCase = TestCaseFactory.getMandatoryFields();
        new LoginPage()
                .open()
                .validLogin(user, password)
                .open("TP")
                .clickOnCaseButton()
                .isOpened()
                .fillInMandatoryFields(testCase)
                .clickOnSaveButton()
                .isTestCaseCreated(testCase.getTitle())
                .clickOnDeleteTestCaseButton(testCase.getTitle())
                .confirmDeletingTestCase()
                .isTestCaseDeleted(testCase.getTitle());
    }
}
