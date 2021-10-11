package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    public static final By PROJECT_NAME = By.xpath("//p[contains(text(), '%s')]");
    public static final By CREATE_NEW_SUITE_BUTTON = By.xpath("//*[contains(text(), 'Create new suite')]");
    public static final By CREATE_NEW_CASE_BUTTON = By.xpath("//*[contains(text(), 'Create new case')]");

    public ProjectDetailsPage isOpened() {
        $(CREATE_NEW_SUITE_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public NewCasePage clickOnCreateNewCaseButton() {
        $(CREATE_NEW_CASE_BUTTON).click();
        return new NewCasePage();
    }
}
