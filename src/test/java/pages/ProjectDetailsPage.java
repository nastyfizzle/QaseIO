package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;

public class ProjectDetailsPage {

    public static final String projectNameLabel = "//*[contains(text(), '%s')]";
    public static final String testCaseNameLabel = "//*[contains(text(),'%s')]";
    public static final String PROJECT_NAME_CSS = "#p.header";

    public static final String CREATE_NEW_CASE_BUTTON = "//*[contains(text(), 'Create new case')]";
    public static final String CASE_BUTTON_CSS = "#create-case-button";
    public static final String DELETE_CASE_BUTTON = "//*[contains(@title,'Delete case')]";
    public static final String CONFIRM_DELETE_CASE_BUTTON = "//*[contains(@class,'modal-footer')]/*[contains(text(),'Delete')]";

    public static final String EDIT_BUTTON = "//*[contains(text(),'Edit')]//*[contains(@class, 'fa fa-pencil-alt')]";

    public static String getProjectName() {
        return $(PROJECT_NAME_CSS).getText();
    }

    public ProjectDetailsPage isOpened(String projectName) {
        $x(String.format(projectNameLabel, projectName)).shouldBe(Condition.exactText(projectName));
        return this;
    }

    public ProjectDetailsPage open(String projectCode) {
        Selenide.open("project/" + projectCode);
        return this;
    }

    //TEST CASE METHODS

    public NewCasePage clickOnCreateNewCaseButton() {
        $(CREATE_NEW_CASE_BUTTON).click();
        return new NewCasePage();
    }

    public NewCasePage clickOnCaseButton() {
        $(CASE_BUTTON_CSS).click();
        return new NewCasePage().isOpened();
    }

    public ProjectDetailsPage clickOnTestCaseName(String testCaseName) {
        $x(String.format(testCaseNameLabel, testCaseName)).click();
        return this;
    }

    public ProjectDetailsPage clickOnDeleteTestCaseButton(String testCaseName) {
        clickOnTestCaseName(testCaseName);
        $x(DELETE_CASE_BUTTON).click();
        return this;
    }

    public ProjectDetailsPage confirmDeletingTestCase() {
        $x(CONFIRM_DELETE_CASE_BUTTON).click();
        return this;
    }

    public ProjectDetailsPage isTestCaseDeleted(String testCaseName) {
        $x(String.format(testCaseNameLabel, testCaseName)).shouldNotBe(Condition.visible);
        return this;
    }

    public ProjectDetailsPage isTestCaseCreated(String testCaseName) {
        $x(String.format(testCaseNameLabel, testCaseName)).shouldBe(Condition.visible);
        return this;
    }
}
