package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String USERNAME_CSS = "#inputEmail";
    public static final String PASSWORD_CSS = "#inputPassword";
    public static final String LOGIN_BUTTON = "#btnLogin";

    public LoginPage open() {
        Selenide.open("login");
        $(PASSWORD_CSS).shouldBe(Condition.visible);
        //$(PASSWORD_CSS).shouldBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }

    public ProjectsPage login(String user, String pass) {
        $(USERNAME_CSS).sendKeys(user);
        $(PASSWORD_CSS).sendKeys(pass);
        $(LOGIN_BUTTON).click();
        return new ProjectsPage().isOpened();
    }
}
