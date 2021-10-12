package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage {

    public static final String PROJECT_NAME_CSS = "#inputTitle";
    public static final String PROJECT_CODE_CSS = "#inputCode";
    public static final String PROJECT_DESCRIPTION_CSS = "#inputDescription";
    public static final String PRIVATE_CHECKBOX_CSS = "#private-access-type";
    public static final String PUBLIC_CHECKBOX_CSS = "#public-access-type";
    public static final String ALL_MEMBERS_CSS = "#accessAll";
    public static final String MEMBERS_FROM_SPECIFIC_GROUP_CSS = "#accessGroup";
    public static final String NO_MEMBERS_CSS = "#accessNone";
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
                $(PRIVATE_CHECKBOX_CSS).click();
                switch (membersAccess) {
                    case "Add all members to this project": {
                        $(ALL_MEMBERS_CSS).click();
                        break;
                    }
                    case "Add members from specific group": {
                        $(MEMBERS_FROM_SPECIFIC_GROUP_CSS).click();
                        break;
                    }
                    case "Don't add members": {
                        $(NO_MEMBERS_CSS).click();
                        break;
                    }
                }
                break;
        }
            case "Public" : {
                $(PUBLIC_CHECKBOX_CSS).click();
                break;
            }
        }
        $(PROJECT_DESCRIPTION_CSS).sendKeys(description);
        $(PUBLIC_CHECKBOX_CSS).click();
        return this;
    }

    public ProjectDetailsPage clickOnCreateProjectButton() {
        $(CREATE_PROJECT_BUTTON).click();
        return new ProjectDetailsPage();
    }
}
