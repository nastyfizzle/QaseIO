package pages;

import com.codeborne.selenide.Condition;
import models.TestCase;
import org.openqa.selenium.By;
import wrappers.Dropdown;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewCasePage {

    public static final String SAVE_BUTTON_CSS = "#save-case";
    public static final By SAVE_AND_CREATE_BUTTON = byXpath("//*[contains(text(), 'Save and create another')]");
    public static final By CANCEL_BUTTON = byXpath("//*[contains(text(), 'Cancel')]");
    public static final String TITLE_INPUT_CSS = "#title";

    public NewCasePage isOpened() {
        $(SAVE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    public NewCasePage fillInFields(TestCase testCase) {
        $(TITLE_INPUT_CSS).sendKeys(testCase.getTitle());
        new Dropdown("Status").selectOption(testCase.getStatus());
        new Dropdown("Suite").selectOption(testCase.getSuite());
        new Dropdown("Severity").selectOption(testCase.getSeverity());
        new Dropdown("Priority").selectOption(testCase.getPriority());
        new Dropdown("Type").selectOption(testCase.getType());
        new Dropdown("Layer").selectOption(testCase.getLayer());
        new Dropdown("Is Flaky").selectOption(testCase.getIsFlaky());
        new Dropdown("Milestone").selectOption(testCase.getMilestone());
        new Dropdown("Behavior").selectOption(testCase.getBehaviour());
        new Dropdown("Automation status").selectOption(testCase.getAutomationStatus());
//        new TextArea("Description").write(testCase.getDescription());
//        new TextArea("Pre-conditions").write(testCase.getPreConditions());
//        new TextArea("Post-conditions").write(testCase.getPostConditions());
        return this;
    }

    public NewCasePage fillInMandatoryFields(TestCase testCase) {
        $(TITLE_INPUT_CSS).sendKeys(testCase.getTitle());
        return this;
    }

    public NewCasePage clearTitleField() {
        $(TITLE_INPUT_CSS).clear();
        return this;
    }

    public NewCasePage updateMandatoryFields(TestCase testCase) {
        clearTitleField();
        $(TITLE_INPUT_CSS).sendKeys(testCase.getTitle());
        return this;
    }

    public ProjectDetailsPage clickOnSaveButton() {
        $(SAVE_BUTTON_CSS).click();
        return new ProjectDetailsPage();
    }
}