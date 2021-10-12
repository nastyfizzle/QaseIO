package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public static final String CREATE_BUTTON_CSS = "#createButton";
    public static final String PROJECT_NAME_CSS = "#a.defect-title";

    public ProjectsPage isOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        $(CREATE_BUTTON_CSS).click();
        return new NewProjectPage().isOpened();
    }

    public ProjectDetailsPage openProject(String name) {
        //$$(PROJECT_NAME).findBy(text(name)).click(); //не работает..у меня не получилось решить эту проблему
        $$(PROJECT_NAME_CSS).find(Condition.text(name)).click(); //этот локатор тоже не работает
        return new ProjectDetailsPage();
    }

    public ProjectDetailsPage openProjectByUrl() {
        Selenide.open("project/TP");
        return new ProjectDetailsPage();
    }

//    public ProjectDetailsPage openProjectByUrl(String projectCode) {
//        Selenide.open("project/" + projectCode)
//    }
}
