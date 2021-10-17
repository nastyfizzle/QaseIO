package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.commons.lang.StringUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectPage {

    public static final String PROJECT_NAME_CSS = "#inputTitle";
    public static final String PROJECT_CODE_CSS = "#inputCode";
    public static final String PROJECT_DESCRIPTION_CSS = "#inputDescription";
    public static final String PRIVATE_CHECKBOX_CSS = "#private-access-type";
    public static final String PUBLIC_CHECKBOX_CSS = "#public-access-type";
    public static final String ALL_MEMBERS_CSS = "#accessAll";
    public static final String MEMBERS_FROM_SPECIFIC_GROUP_CSS = "#accessGroup";
    public static final String NO_MEMBERS_CSS = "#accessNone";
    public static final String CREATE_PROJECT_BUTTON = "//button[contains(text(), 'Create project')]";

    public NewProjectPage isOpened() {
        $x(CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public NewProjectPage open() {
        Selenide.open("projects/create");
        return this;
    }

    public NewProjectPage fillInFields(String projectName, String projectCode, String description,
                                       String projectAccessType, String membersAccess) {
        $(PROJECT_NAME_CSS).sendKeys(projectName);
        if (StringUtils.isNotEmpty(projectCode)) {
            $(PROJECT_CODE_CSS).sendKeys(projectCode);
        }
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
        $x(CREATE_PROJECT_BUTTON).click();
        return new ProjectDetailsPage();
    }
}
