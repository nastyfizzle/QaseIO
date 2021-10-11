package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import wrappers.Dropdown;
import wrappers.TextArea;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewCasePage {

    public static final String SAVE_BUTTON = "#save-case";
    public static final By SAVE_AND_CREATE_BUTTON = byXpath("//*[contains(text(), 'Save and create another')]");
    public static final By CANCEL_BUTTON = byXpath("//*[contains(text(), 'Cancel')]");
    public static final String TITLE_FIELD = "#title";
    public static final String TEXT_AREA = "#undefinedGroup.form-group";

    public NewCasePage isOpened() {
        $(SAVE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public NewCasePage fillInFields(String title, String statusOption, String suiteOption, String severityOption,
                                    String priorityOption, String descriptionText) {
        $(TITLE_FIELD).sendKeys(title);
        new Dropdown("Status").selectOption(statusOption);
        new Dropdown("Suite").selectOption(suiteOption);
        new Dropdown("Severity").selectOption(severityOption);
        new Dropdown("Priority").selectOption(priorityOption);
        new TextArea("Description").write(descriptionText);
        return this;
    }

    public ProjectDetailsPage clickOnSaveButton() {
        $(SAVE_BUTTON).click();
        return new ProjectDetailsPage();
    }
}
