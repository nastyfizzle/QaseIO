package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TextArea {

    String label;
    String textAreaLocator = "//label[text()='%s']/ancestor::div[contains(@class,'form-group')]";

    public TextArea(String label) {
        this.label = label;
    }

    public void write(String text) {
        $(By.xpath(String.format(textAreaLocator, label))).sendKeys(text);
    }
}
