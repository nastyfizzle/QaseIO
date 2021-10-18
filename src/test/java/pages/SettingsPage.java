package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {

    public static final String PROJECT_NAME_CSS = "#inputTitle";

    public static final String UPDATE_SETTINGS_BUTTON = "//*[contains(text(), 'Update settings')]";
    public static final String DELETE_PROJECT_BUTTON = "//*[contains(text(), 'Delete project')]";
    public static final String CONFIRM_DELETE_BUTTON = "//*[contains(@type, 'submit')]";

    public SettingsPage open(String projectCode) {
        Selenide.open("/project/" + projectCode + "/settings/general");
        return this;
    }

    public SettingsPage isOpened() {
        $x(UPDATE_SETTINGS_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public SettingsPage clickOnDelete() {
        $(DELETE_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectsPage confirmProjectDeleting() {
        $(CONFIRM_DELETE_BUTTON).click();
        return new ProjectsPage();
    }

    public SettingsPage editProjectTitle(String newProjectName) {
        $(PROJECT_NAME_CSS).clear();
        $(PROJECT_NAME_CSS).sendKeys(newProjectName);
        return this;
    }

    public SettingsPage clickOnUpdate() {
        $x(UPDATE_SETTINGS_BUTTON).click();
        return this;
    }

    public SettingsPage isProjectTitleUpdated(String projectName) {
        $x(String.format(PROJECT_NAME_CSS, projectName)).shouldBe(Condition.visible);
        return this;
    }
}
