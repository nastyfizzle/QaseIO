package tests;

import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewCasePage;
import pages.ProjectDetailsPage;

public class CaseTest extends BaseTest {

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login("nastasv691@gmail.com", "Nastya123!")
                .openProjectByUrl();
        new ProjectDetailsPage()
                .clickOnCreateNewCaseButton()
                .isOpened();
        TestCase testCase = TestCaseFactory.getAllFields();
        new NewCasePage()
                .fillInFields(testCase)
                .clickOnSaveButton();
    }
}
