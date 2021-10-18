package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String USERNAME_CSS = "#inputEmail";
    public static final String PASSWORD_CSS = "#inputPassword";
    public static final String LOGIN_BUTTON = "#btnLogin";
    public static final String errorTextLocator = ".form-control-feedback";

    public LoginPage open() {
        Selenide.open("login");
        return this;
    }

    public LoginPage isOpened() {
        $(PASSWORD_CSS).shouldBe(Condition.visible);
        return this;
    }

    public LoginPage fillInFormAndSubmit(String user, String pass) {
        $(USERNAME_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(pass);
        $(LOGIN_BUTTON).click();
        return this;
    }

    public ProjectsPage validLogin(String user, String pass) {
        fillInFormAndSubmit(user, pass);
        return new ProjectsPage().isOpened();
    }

    public LoginPage invalidLogin(String user, String pass) {
        fillInFormAndSubmit(user, pass);
        return this;
    }

    public LoginPage isErrorAppeared() {
        $(errorTextLocator).shouldBe(Condition.visible);
        return this;
    }

    public String getErrorText() {
        return $(errorTextLocator).getText();
    }

    @Step("Observe the error text")
    public LoginPage validateErrorText(String errorText) {
        Assert.assertEquals(getErrorText(), errorText, "Error doesn't correspond to expected");
        return this;
    }
}
