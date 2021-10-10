package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    //public static final String PROJECT_NAME = String.valueOf($(byXpath("//p[contains(text(), '%s')]")));
    public static final By CREATE_NEW_SUITE_BUTTON = byXpath("//*[contains(text(), 'Create new suite')]");

    public ProjectDetailsPage isOpened() {
        $(CREATE_NEW_SUITE_BUTTON).shouldBe(Condition.visible);
        return this;
    }
}
