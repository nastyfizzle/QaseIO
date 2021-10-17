package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteProjectPage {

    public static final String DELETE_PROJECT_BUTTON = "//*[contains(@class, 'btn') and contains(text(),' Delete project')]";

    public DeleteProjectPage isOpened() {
        $x(DELETE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage confirmDeleting() {
        $x(DELETE_PROJECT_BUTTON).click();
        return new ProjectsPage();
    }
}
