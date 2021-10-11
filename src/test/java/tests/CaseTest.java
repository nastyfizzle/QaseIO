package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
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
                .isOpened()
                .fillInFields("Any test case name", "Actual", "Test case wuthout suite",
                        "Major", "Low","Any description text here")
                .clickOnSaveButton();
    }
}
