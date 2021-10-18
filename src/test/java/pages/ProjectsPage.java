package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectsPage {

    public static final String CREATE_NEW_PROJECT_BUTTON_CSS = "#createButton";
    public static final String projectNameLabel = "//table[contains(@class,'table')]//*[contains(text(), '%s')]";
    public static final String threeDotsMenuLocator = "//*[contains(text(),'%s')]/ancestor::tr/descendant::a[contains(@class, 'btn')]";
    public static final String deleteOptionLocator = "//*[contains(text(),'%s')]/ancestor::tr/descendant::a[contains(text(), 'Delete')]";
    public static final String settingsOptionLocator = "//*[contains(text(),'%s')]/ancestor::tr/descendant::a[contains(text(), 'Settings')]";

    public ProjectsPage open() {
        Selenide.open("projects");
        return this;
    }

    public ProjectsPage isOpened() {
        $(CREATE_NEW_PROJECT_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    public ProjectDetailsPage open(String projectCode) {
        Selenide.open("project/" + projectCode);
        return new ProjectDetailsPage();
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        $(CREATE_NEW_PROJECT_BUTTON_CSS).click();
        return new NewProjectPage();
    }

    public ProjectsPage isProjectCreated(String projectName) {
        $x(String.format(projectNameLabel, projectName)).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage clickOnThreeDotsButton(String projectName) {
        $x(String.format(threeDotsMenuLocator, projectName)).click();
        return this;
    }

    public DeleteProjectPage clickOnDeleteProjectOption(String projectName) {
        clickOnThreeDotsButton(projectName);
        $x(String.format(deleteOptionLocator, projectName)).click();
        return new DeleteProjectPage();
    }

    public SettingsPage clickOnSettingsOption(String projectName) {
        clickOnThreeDotsButton(projectName);
        $x(String.format(settingsOptionLocator, projectName)).click();
        return new SettingsPage();
    }

    public ProjectsPage isProjectDeleted(String projectName) {
        $x(String.format(projectNameLabel, projectName)).shouldNotBe(Condition.visible);
        return this;
    }
}
