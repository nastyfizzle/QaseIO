package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage {

    public static final String PROJECT_NAME_CSS = "#inputTitle";
    public static final String PROJECT_CODE_CSS = "#inputCode";
    public static final String PROJECT_DESCRIPTION = "#inputDescription";
    public static final String PRIVATE_CHECKBOX = "#private-access-type";
    public static final String PUBLIC_CHECKBOX = "#public-access-type";
    public static final String ALL_MEMBERS = "#accessAll";
    public static final String MEMBERS_FROM_SPECIFIC_GROUP = "#accessGroup";
    public static final String NO_MEMBERS = "#accessNone";
    public static final By CREATE_PROJECT_BUTTON = byXpath("//button[contains(text(), 'Create project')]");

    public NewProjectPage isOpened() {
        $(CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public NewProjectPage fillInFields(String projectName, String projectCode, String description,
                                       String projectAccessType, String membersAccess) {
        $(PROJECT_NAME_CSS).sendKeys(projectName);
        if (StringUtils.isNotEmpty(projectCode)) {
            $(PROJECT_CODE_CSS).sendKeys(projectCode);
        }
//        $(PROJECT_CODE_CSS).clear();
//        $(PROJECT_CODE_CSS).sendKeys(projectCode);
        switch (projectAccessType) {
            case "Private": {
                $(PRIVATE_CHECKBOX).click();
                switch (membersAccess) {
                    case "Add all members to this project": {
                        $(ALL_MEMBERS).click();
                        break;
                    }
                    case "Add members from specific group": {
                        $(MEMBERS_FROM_SPECIFIC_GROUP).click();
                        break;
                    }
                    case "Don't add members": {
                        $(NO_MEMBERS).click();
                        break;
                    }
                }
                break;
        }
            case "Public" : {
                $(PUBLIC_CHECKBOX).click();
                break;
            }
        }
        $(PROJECT_DESCRIPTION).sendKeys(description);
        $(PUBLIC_CHECKBOX).click();
        return this;
    }

    public ProjectDetailsPage clickOnCreateProjectButton() {
        $(CREATE_PROJECT_BUTTON).click();
        return new ProjectDetailsPage();
    }
}
