package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    public static final By PROJECT_NAME = By.xpath("//p[contains(text(), '%s')]");
    public static final By CREATE_NEW_SUITE_BUTTON = By.xpath("//*[contains(text(), 'Create new suite')]");
    public static final By CREATE_NEW_CASE_BUTTON = By.xpath("//*[contains(text(), 'Create new case')]");
    public static final String CASE_BUTTON_CSS = "#create-case-button";
    public static final String TEST_CASE_NAME = ".case-row-title";
    public static final By TEST_CASE_CHECKBOX = By.xpath("//span[contains(@class, 'custom-control-indicator')]/ancestor::div[contains(@class, 'case-drag')]");
    public static final By TEST_SUITE_CHECKBOX = By.xpath("//span[contains(@class, 'custom-control-indicator')]/ancestor::div[contains(@class, 'suite-block')]");
    public static final By DELETE_BUTTON = By.xpath("//*[contains(text(),'Delete')]//*[contains(@class, 'fa-trash')]");
    public static final By EDIT_BUTTON = By.xpath("//*[contains(text(),'Edit')]//*[contains(@class, 'fa fa-pencil-alt')]");
    public static final By INPUT_FIELD_CONFIRM_FORM = By.xpath("//*[contains(@class, 'form-control')]/parent::div[contains(@class, 'form-group')]");
    public static final By DELETE_BUTTON_CONFIRM_FORM = By.xpath("//*[contains(text(), 'Delete')]/parent::div[contains(@class, 'modal-footer')]");
    public static final By CREATE_CASE_BUTTON_AT_THE_BOTTOM = By.xpath("//*[contains(text(), '+ Create case')]/ancestor::div[contains(@id, 'suitecases-container')]");

    public ProjectDetailsPage isOpened() {
        $(CREATE_NEW_SUITE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public NewCasePage clickOnCreateNewCaseButton() {
        $(CREATE_NEW_CASE_BUTTON).click();
        return new NewCasePage().isOpened();
    }

    public NewCasePage clickOnCaseButton() {
        $(CASE_BUTTON_CSS).click();
        return new NewCasePage().isOpened();
    }

    public static String getTestCaseName() {
        return $(TEST_CASE_NAME).getText();
    }

    public ProjectDetailsPage clickOnTestCaseCheckBox() {
        $(TEST_CASE_CHECKBOX).click();
        return this;
    }
     public ProjectDetailsPage confirmDeletingTestCaseOrSuite() {
        $(DELETE_BUTTON).click();
        $(INPUT_FIELD_CONFIRM_FORM).sendKeys("CONFIRM");
        $(DELETE_BUTTON_CONFIRM_FORM).shouldBe(Condition.visible).click();
        return this;
     }

    public NewCasePage clickOnCreateCaseButton() {
        $(CREATE_CASE_BUTTON_AT_THE_BOTTOM).click();
        return new NewCasePage().isOpened();
    }
}
