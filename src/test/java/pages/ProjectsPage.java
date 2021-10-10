package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public static final String CREATE_BUTTON_CSS = "#createButton";
    //public static final By projectName = By.xpath("defect-title")

    public ProjectsPage isOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        $(CREATE_BUTTON_CSS).click();
        return new NewProjectPage().isOpened();
    }

    public ProjectDetailsPage openProject(String name) {
        $$("a.defect-title").findBy(text(name)).click();
        $$(By.xpath("//div[contains(@id, 'react-select')]")).findBy(text("option")).click();
        return new ProjectDetailsPage();
    }
}

//дописать обертку на дропдану
//написать тайтл
//описание и другие поля - задание со *
