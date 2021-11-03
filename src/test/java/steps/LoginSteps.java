package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;
import pages.ProjectsPage;

@Log4j2
public class LoginSteps {

    LoginPage loginPage;
    ProjectsPage projectsPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @Step("Authorize with valid credentials: {username}, {password}")
    public ProjectsPage login(String username, String password) {
        log.info("Authorize with valid credentials: {}, {}", username, password);
        loginPage
                .open()
                .validLogin(username, password)
                .isOpened();
        return projectsPage;
    }

    @Step("Authorize with invalid credentials: {username}, {password}")
    public LoginPage login(String username, String password, String errorText) {
        log.info("Authorize with invalid credentials: {}, {}", username, password);
        loginPage
                .open()
                .invalidLogin(username, password)
                .isErrorAppeared()
                .validateErrorText(errorText);
        return loginPage;
    }
}
