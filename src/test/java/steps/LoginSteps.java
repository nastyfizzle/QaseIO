package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Step("Authorize with valid credentials: {username}, {password}")
    public void login(String username, String password) {
        loginPage
                .open()
                .validLogin(username, password)
                .isOpened();
    }

    @Step("Authorize with invalid credentials")
    public LoginPage login(String username, String password, String errorText) {
        loginPage
                .open()
                .invalidLogin(username, password)
                .isErrorAppeared()
                .validateErrorText(errorText);
        return loginPage;
    }
}
