package wrappers;

import org.openqa.selenium.By;
import pages.NewCasePage;

import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    String label;
    String dropdownLocator = "//*[text()='%s']/parent::div//div[contains(@class, 'container')]";
    String optionLocator = "//*[contains(@id, 'react-select') and contains(text(),'%s')]";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        $(By.xpath(String.format(dropdownLocator, label))).click();
        $(By.xpath(String.format(optionLocator, option))).click();
    }
}
