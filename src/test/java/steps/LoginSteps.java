package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginSteps {

    LoginPage loginPage;
    ProjectsPage projectsPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @Step("Authorize with valid credentials: {username}, {password}")
    public ProjectsPage login(String username, String password) {
        loginPage
                .open()
                .validLogin(username, password)
                .isOpened();
        return projectsPage;
    }

    @Step("Authorize with invalid credentials: {username}, {password}")
    public LoginPage login(String username, String password, String errorText) {
        loginPage
                .open()
                .invalidLogin(username, password)
                .isErrorAppeared()
                .validateErrorText(errorText);
        return loginPage;
    }
}
